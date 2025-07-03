package com.grab.zone_desk_service.services.ServiceImplementation;

import com.grab.zone_desk_service.models.Desk;
import com.grab.zone_desk_service.models.Status;
import com.grab.zone_desk_service.models.Zone;
import com.grab.zone_desk_service.repositories.DeskRepository;
import com.grab.zone_desk_service.repositories.ZoneRepository;
import com.grab.zone_desk_service.services.DeskService;
import com.grab.zone_desk_service.wrappers.Utils;
import com.grab.zone_desk_service.wrappers.UtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskRepository deskRepository;
    @Autowired
    private ZoneRepository zoneRepository;

    private final Utils utils = new UtilsImpl();

    @Override
    public ResponseEntity<Long> createDesk(Long zoneId) {
        if (zoneId == null || zoneId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        if (zoneRepository.existsById(zoneId)) {
            Optional<Zone> zone = zoneRepository.findById(zoneId);
            if (zone.isPresent()) {
                int noOfDesks = deskRepository.getDeskByZoneId(zoneId).size();
                String deskNumber = utils.generateDeskNumber(zone.get().getZoneNumber(), noOfDesks);
                Desk desk = new Desk();
                desk.setZoneId(zoneId);
                desk.setDeskNumber(deskNumber);
                desk.setStatus(Status.AVAILABLE);
                Desk savedDesk = deskRepository.save(desk);
                return ResponseEntity.ok(savedDesk.getDeskId());
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Desk>> getDesksByZoneId(Long zoneId) {
        if (zoneId == null || zoneId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        List<Desk> desks = deskRepository.findAllByZoneId(zoneId);
        return ResponseEntity.ok(desks);
    }

    @Override
    public ResponseEntity<Desk> getDeskById(Long deskId) {
        return deskRepository.findById(deskId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Desk> updateDeskById(Long deskId, Desk desk) {
        if (deskId == null || deskId <= 0 || !deskRepository.existsById(deskId)) {
            return ResponseEntity.badRequest().build();
        }
        if (deskRepository.existsById(deskId)) {
            if (desk.getDeskNumber() == null || desk.getDeskNumber().trim().isEmpty() || desk.getZoneId() == null) {
                return ResponseEntity.badRequest().build();
            }
            if (!zoneRepository.existsById(desk.getZoneId())) {
                return ResponseEntity.badRequest().build();
            }
            desk.setDeskId(deskId);
            Desk updatedDesk = deskRepository.saveAndFlush(desk);
            return ResponseEntity.ok(updatedDesk);
        }
        return ResponseEntity.badRequest().build();
    }


    @Override
    public ResponseEntity<Desk> deleteDeskById(Long deskId) {
        if (deskId == null || deskId <= 0 || !deskRepository.existsById(deskId)) {
            return ResponseEntity.badRequest().build();
        }
        if (deskRepository.existsById(deskId)) {
            Desk desk = deskRepository.findById(deskId).get();
            deskRepository.deleteById(deskId);
            return ResponseEntity.ok(desk);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<List<Desk>> deleteDesksByZoneId(Long zoneId) {
        if (zoneId == null || zoneId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        if (!zoneRepository.existsById(zoneId)) {
            return ResponseEntity.badRequest().build();
        }
        List<Desk> desks = deskRepository.findAllByZoneId(zoneId);
        if (desks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        deskRepository.deleteAll(desks);
        return ResponseEntity.ok(desks);
    }
}
