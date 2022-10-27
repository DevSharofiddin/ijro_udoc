package com.ijro_udoc.controller;

import com.ijro_udoc.model.Company;
import com.ijro_udoc.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/company-post")
    public ResponseEntity<?> companyPost(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.save(company));
    }

    @PutMapping("/company-put")
    public ResponseEntity<?> companyPut(@RequestBody Company company) {
        Company company1 = companyService.findById(company.getId());
        company.setCreated_at(company1.getCreated_at());
        return ResponseEntity.ok(companyService.save(company));
    }

    @DeleteMapping("/company-del/{id}")
    public ResponseEntity<?> companyDelOne(@PathVariable Integer id) {
        companyService.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/company")
    public ResponseEntity<?> companyGet() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<?> companyGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(companyService.findById(id));
    }
}
