package com.grab.zone_desk_service.services;

import com.grab.zone_desk_service.models.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZoneService {
    ResponseEntity<Long> buildZone(Long floorId);

    ResponseEntity<List<Zone>> fetchAllZonesByFloorId(Long floorId);

    ResponseEntity<Zone> modifyZoneById(Long zoneId, Zone zone);

    ResponseEntity<String> removeZoneById(Long zoneId);
}
