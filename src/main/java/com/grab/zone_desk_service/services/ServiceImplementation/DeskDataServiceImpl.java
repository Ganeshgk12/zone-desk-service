package com.grab.zone_desk_service.services.ServiceImplementation;

import com.grab.zone_desk_service.models.Desk;
import com.grab.zone_desk_service.models.Status;
import com.grab.zone_desk_service.repositories.DeskRepository;
import com.grab.zone_desk_service.services.DeskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeskDataServiceImpl implements DeskDataService {

    @Autowired
    private DeskRepository deskRepository;

    @Override
    public ResponseEntity<String> getDeskNumber(Long deskId) {
        if (deskRepository.existsById(deskId)) {
            String deskNumber = deskRepository.getDeskByDeskId(deskId).getDeskNumber();
            return ResponseEntity.ok(deskNumber);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Boolean> validateDesk(Long deskId) {
        if (deskId == null) {
            return ResponseEntity.badRequest().build();
        }
        if (deskRepository.existsById(deskId)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> changeStatus(Long deskId, String status) {
        if (deskId != null && status != null && deskRepository.existsById(deskId)) {
            Desk existingDesk = deskRepository.getDeskByDeskId(deskId);
            existingDesk.setStatus(Status.valueOf(status));
            deskRepository.save(existingDesk);
            return ResponseEntity.ok().body("Status changed to " + status);
        }
        return ResponseEntity.badRequest().body("Something went wrong please try again.");
    }
}
