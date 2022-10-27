package com.ijro_udoc.controller;

import com.ijro_udoc.model.Organization_types;
import com.ijro_udoc.model.Organizations;
import com.ijro_udoc.model.dto.OrganizationsRequestDto;
import com.ijro_udoc.service.OrganizationService;
import com.ijro_udoc.service.Organization_typesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OrganizationsController {

    private final OrganizationService organizationService;
    private final Organization_typesService organization_typesService;

    public OrganizationsController(OrganizationService organizationService, Organization_typesService organization_typesService) {
        this.organizationService = organizationService;
        this.organization_typesService = organization_typesService;
    }

    @PostMapping("/organizations-post")
    public ResponseEntity<?> organizationsPost(@RequestBody OrganizationsRequestDto body) {

        Organization_types organization_types = organization_typesService.findById(body.getOrganization_typesId());
        Organizations organizations1 = new Organizations(body, organization_types);

        return ResponseEntity.ok(organizationService.save(organizations1));
    }

    @PutMapping("/organizations-put")
    public ResponseEntity<?> organizationsPut(@RequestBody OrganizationsRequestDto body){

        //created_at
        Organizations organizations = organizationService.findById(body.getId());
        body.setCreated_at(organizations.getCreated_at());

        Organization_types organization_types = organization_typesService.findById(body.getOrganization_typesId());
        Organizations organizations1 = new Organizations(body, organization_types);

        return ResponseEntity.ok(organizationService.save(organizations1));
    }

    @GetMapping("/organizations")
    public ResponseEntity<?> organizationsGet() {
        return ResponseEntity.ok(organizationService.findAll());
    }

    @GetMapping("/organizations/{id}")
    public ResponseEntity<?> organizationsGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(organizationService.findById(id));
    }

    @DeleteMapping("/organizations-del/{id}")
    public ResponseEntity<?> organizationsDelOne(@PathVariable Integer id) {
        organizationService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
