package com.ijro_udoc.controller;

import com.ijro_udoc.model.Organization_types;
import com.ijro_udoc.service.Organization_typesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Organization_typesController {

    private final Organization_typesService organization_typesService;

    public Organization_typesController(Organization_typesService organization_typesService) {
        this.organization_typesService = organization_typesService;
    }

    @PostMapping("/organization_types-post")
    public ResponseEntity<?> organization_typesPost(@RequestBody Organization_types organization_types) {
        return ResponseEntity.ok(organization_typesService.save(organization_types));
    }

    @PutMapping("/organization_types-put")
    public ResponseEntity<?> organization_typesPut(@RequestBody Organization_types organization_types) {
        Organization_types organization_types1 = organization_typesService.findById(organization_types.getId());
        organization_types.setCreated_at(organization_types1.getCreated_at());
        return ResponseEntity.ok(organization_typesService.save(organization_types));
    }

    @GetMapping("/organization_types")
    public ResponseEntity<?> organization_typesGet() {
        return ResponseEntity.ok(organization_typesService.findAll());
    }

    @GetMapping("/organization_types/{id}")
    public ResponseEntity<?> organization_typesGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(organization_typesService.findById(id));
    }

    @DeleteMapping("/organization_types-del/{id}")
    public ResponseEntity<?> organization_typesDelOne(@PathVariable Integer id) {
        organization_typesService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
