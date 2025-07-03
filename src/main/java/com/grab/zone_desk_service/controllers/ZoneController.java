package com.grab.zone_desk_service.controllers;

import com.grab.zone_desk_service.models.Zone;
import com.grab.zone_desk_service.services.ZoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-admin/zone")
public class ZoneController {

    private ZoneService zoneService;

    @PostMapping("/create-zone")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> createZone(@RequestParam Long floorId, @RequestParam String zone_name){
        return zoneService.buildZone(floorId);
    }

    @GetMapping("/getzonesby-floorId/{floorId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Zone>> getZonesByFloorId(@PathVariable Long floorId){
        return zoneService.fetchAllZonesByFloorId(floorId);
    }

    @PutMapping("/updatezoneby-zoneId/{zoneId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Zone> updateZone(@PathVariable Long zoneId, @RequestBody Zone zone){
        return zoneService.modifyZoneById(zoneId, zone);
    }

    @DeleteMapping("deletezoneby-zoneId/{zoneId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteZone(@PathVariable Long zoneId){
        return zoneService.removeZoneById(zoneId);
    }
}
