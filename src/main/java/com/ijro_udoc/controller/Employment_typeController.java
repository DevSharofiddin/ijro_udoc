package com.ijro_udoc.controller;

import com.ijro_udoc.model.Employment_type;
import com.ijro_udoc.service.Employment_typeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Employment_typeController {

    public final Employment_typeService employment_typeService;

    public Employment_typeController(Employment_typeService employment_typeService) {
        this.employment_typeService = employment_typeService;
    }

    @PostMapping("/employment_type-post")
    public ResponseEntity<?> employment_typePost(@RequestBody Employment_type employment_type) {
        return ResponseEntity.ok(employment_typeService.save(employment_type));
    }

    @PutMapping("/employment_type-put")
    public ResponseEntity<?> employment_typePut(@RequestBody Employment_type employment_type) {
        Employment_type employment_type1 = employment_typeService.findById(employment_type.getId());
        employment_type.setCreated_at(employment_type1.getCreated_at());
        return ResponseEntity.ok(employment_typeService.save(employment_type));
    }

    @GetMapping("/employment_type")
    public ResponseEntity<?> employment_typeGet() {
        return ResponseEntity.ok(employment_typeService.findAll());
    }

    @GetMapping("/employment_type/{id}")
    public ResponseEntity<?> employment_typeGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(employment_typeService.findById(id));
    }

    @DeleteMapping("/employment_type-del/{id}")
    public ResponseEntity<?> employment_typeDelOne(@PathVariable Integer id) {
        employment_typeService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
