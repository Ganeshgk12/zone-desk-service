package com.grab.zone_desk_service.services.ServiceImplementation;

import com.grab.zone_desk_service.models.Zone;
import com.grab.zone_desk_service.repositories.ZoneRepository;
import com.grab.zone_desk_service.services.ZoneService;
import com.grab.zone_desk_service.wrappers.Utils;
import com.grab.zone_desk_service.wrappers.UtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    private final Utils utils = new UtilsImpl();

    @Override
    public ResponseEntity<Long> buildZone(Long floorId) {
        // TODO: VALIDATE THE FLOOR ID, AND GET THE FLOOR NUMBER(B1-F2)
        Zone zone = new Zone();
        String zoneNumber = utils.generateZoneNumber("",1);  // TODO: NEED TO SEND ACTUAL VALUE HERE(floorNo, prevCnt)
        zone.setZoneNumber(zoneNumber);
        zone.setFloorId(floorId);
        zoneRepository.save(zone);
        return ResponseEntity.ok().body(zone.getZoneId());
    }

    @Override
    public ResponseEntity<List<Zone>> fetchAllZonesByFloorId(Long floorId) {
        // TODO: Need to validate the floorId from dot net service
        List<Zone> zones = zoneRepository.findAllByFloorId(floorId);
        return ResponseEntity.ok().body(zones);
    }

    @Override
    public ResponseEntity<Zone> modifyZoneById(Long zoneId, Zone zone) {
        if (zoneId == null || zoneId <= 0 || !zoneRepository.existsById(zoneId)) {
            return ResponseEntity.badRequest().build();
        }
        // Fetch existing zone
        Zone existingZone = zoneRepository.findById(zoneId).orElse(null);
        if (existingZone == null) {
            return ResponseEntity.notFound().build();
        }

        // Update values
        existingZone.setFloorId(zone.getFloorId());
        // Save updated zone
        zoneRepository.saveAndFlush(existingZone);
        return ResponseEntity.ok().body(existingZone);
    }

    @Override
    public ResponseEntity<String> removeZoneById(Long zoneId) {
        if (zoneId == null || zoneId <= 0 || !zoneRepository.existsById(zoneId)) {
            return ResponseEntity.badRequest().body("Invalid zone ID or zone does not exist.");
        }

        zoneRepository.deleteById(zoneId);
        return ResponseEntity.ok("Zone deleted successfully.");
    }

}
