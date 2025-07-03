package com.grab.zone_desk_service.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DeskDataService {

    ResponseEntity<String> getDeskNumber(Long deskId);

    ResponseEntity<Boolean> validateDesk(Long deskId);

    ResponseEntity<String> changeStatus(Long deskId, String status);
}
