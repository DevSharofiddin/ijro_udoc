package com.ijro_udoc.controller;

import com.ijro_udoc.model.Positions;
import com.ijro_udoc.service.PositionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PositionsController {

    private final PositionsService positionsService;

    public PositionsController(PositionsService positionsService) {
        this.positionsService = positionsService;
    }

    @PostMapping("/positions-post")
    public ResponseEntity<?> positionsPost(@RequestBody Positions positions) {
        return ResponseEntity.ok(positionsService.save(positions));
    }

    @PutMapping("/positions-put")
    public ResponseEntity<?> positionsPut(@RequestBody Positions positions) {
        Positions positions1 = positionsService.findById(positions.getId());
        positions.setCreated_at(positions1.getCreated_at());
        return ResponseEntity.ok(positionsService.save(positions));
    }

    @GetMapping("/positions")
    public ResponseEntity<?> positionsGet() {
        return ResponseEntity.ok(positionsService.findAll());
    }

    @GetMapping("/positions/{id}")
    public ResponseEntity<?> positionsGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(positionsService.findById(id));
    }

    @DeleteMapping("/positions-del/{id}")
    public ResponseEntity<?> positionsDelOne(@PathVariable Integer id) {
        positionsService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
