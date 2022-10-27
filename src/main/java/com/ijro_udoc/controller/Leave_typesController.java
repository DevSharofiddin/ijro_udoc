package com.ijro_udoc.controller;

import com.ijro_udoc.model.Leave_types;
import com.ijro_udoc.service.Leave_tupesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Leave_typesController {

    private final Leave_tupesService leave_tupesService;

    public Leave_typesController(Leave_tupesService leave_tupesService) {
        this.leave_tupesService = leave_tupesService;
    }

    @PostMapping("/leave_types-post")
    public ResponseEntity<?> leave_typesPost(@RequestBody Leave_types leave_types) {
        return ResponseEntity.ok(leave_tupesService.save(leave_types));
    }

    @PutMapping("/leave_types-put")
    public ResponseEntity<?> leave_typesPut(@RequestBody Leave_types leave_types) {
        Leave_types leave_types1 = leave_tupesService.findById(leave_types.getId());
        leave_types.setCreated_at(leave_types1.getCreated_at());
        return ResponseEntity.ok(leave_tupesService.save(leave_types));
    }

    @GetMapping("/leave_types")
    public ResponseEntity<?> leave_typesGet() {
        return ResponseEntity.ok(leave_tupesService.findAll());
    }

    @GetMapping("/leave_types/{id}")
    public ResponseEntity<?> leave_typesGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(leave_tupesService.findById(id));
    }

    @DeleteMapping("/leave_types/{id}")
    public ResponseEntity<?> leave_typesDelOne(@PathVariable Integer id) {
        leave_tupesService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
