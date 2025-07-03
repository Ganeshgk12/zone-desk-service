package com.grab.zone_desk_service.controllers;

import com.grab.zone_desk_service.models.Desk;
import com.grab.zone_desk_service.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-admin/desk")
public class DeskController {

    @Autowired
    private DeskService deskService;

    @PostMapping("/create-desk")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> createDesk(@RequestParam Long zoneId){
        return deskService.createDesk(zoneId);
    }

    @GetMapping("/getalldesksby-zoneId/{zoneId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Desk>> getAllDesksByZoneId(@PathVariable Long zoneId){
        return deskService.getDesksByZoneId(zoneId);
    }

    @GetMapping("/getdesksby-deskId/{deskId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Desk> getDesk(@PathVariable Long deskId){
        return deskService.getDeskById(deskId);
    }

    @PutMapping("/updatedeskby-deskId/{deskId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Desk> updateDesk(@PathVariable Long deskId, @RequestBody Desk desk){
        return deskService.updateDeskById(deskId, desk);
    }

    @DeleteMapping("deletedeskby-deskId/{deskId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Desk> deleteDesk(@PathVariable Long deskId){
        return deskService.deleteDeskById(deskId);
    }

    @DeleteMapping("deletedesksby-zoneId/{zoneId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Desk>> deleteZoneDesks(@PathVariable Long zoneId){
        return deskService.deleteDesksByZoneId(zoneId);
    }
}
