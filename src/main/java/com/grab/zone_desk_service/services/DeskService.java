package com.grab.zone_desk_service.services;

import com.grab.zone_desk_service.models.Desk;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeskService {
    ResponseEntity<Long> createDesk(Long zoneId);
    ResponseEntity<List<Desk>> getDesksByZoneId(Long zoneId);
    ResponseEntity<Desk> getDeskById(Long deskId);
    ResponseEntity<Desk> updateDeskById(Long deskId, Desk desk);
    ResponseEntity<Desk> deleteDeskById(Long deskId);
    ResponseEntity<List<Desk>> deleteDesksByZoneId(Long zoneId);
}
