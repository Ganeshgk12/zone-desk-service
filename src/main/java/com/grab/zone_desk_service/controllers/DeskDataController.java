package com.grab.zone_desk_service.controllers;

import com.grab.zone_desk_service.services.DeskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/data")
public class DeskDataController {

    @Autowired
    private DeskDataService deskDataService;

    @GetMapping("/getdesknumber/{deskId}")
    public ResponseEntity<String> getDeskNumber(@PathVariable("deskId") Long deskId) {
        return deskDataService.getDeskNumber(deskId);
    }

    @GetMapping("/check-desk/{deskId}")
    public ResponseEntity<Boolean> checkDesk(@PathVariable("deskId") Long deskId) {
        return deskDataService.validateDesk(deskId);
    }

    @PostMapping("/changeDeskStatus")
    ResponseEntity<String> changeDeskStatus(@RequestParam("deskId") Long deskId, @RequestParam String status){
        return deskDataService.changeStatus(deskId, status);
    }
}
