package com.ijro_udoc.controller;

import com.ijro_udoc.model.Offices;
import com.ijro_udoc.service.OfficesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class OfficesController {

    private final OfficesService officesService;

    public OfficesController(OfficesService officesService) {
        this.officesService = officesService;
    }

    @PostMapping("/offices-post")
    public ResponseEntity<?> officesPost(@RequestBody Offices offices) {
        return ResponseEntity.ok(officesService.save(offices));
    }

    @PutMapping("/offices-put")
    public ResponseEntity<?> officesPut(@RequestBody Offices offices) {
        Offices offices1 = officesService.findById(offices.getId());
        offices.setCreated_at(offices1.getCreated_at());
        return ResponseEntity.ok(officesService.save(offices));
    }

    @GetMapping("/offices")
    public ResponseEntity<?> officesGet() {
        return ResponseEntity.ok(officesService.findAll());
    }

    @GetMapping("/offices/{id}")
    public ResponseEntity<?> officesGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(officesService.findById(id));
    }

    @DeleteMapping("/offices-del/{id}")
    public ResponseEntity<?> officesDelOne(@PathVariable Integer id) {
        officesService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
