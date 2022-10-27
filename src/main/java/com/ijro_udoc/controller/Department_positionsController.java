package com.ijro_udoc.controller;

import com.ijro_udoc.model.Department_positions;
import com.ijro_udoc.model.Departments;
import com.ijro_udoc.model.Positions;
import com.ijro_udoc.model.dto.Department_positionsRequestDto;
import com.ijro_udoc.service.Department_positionsService;
import com.ijro_udoc.service.DepartmentsService;
import com.ijro_udoc.service.PositionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Department_positionsController {

    private final Department_positionsService department_positionsService;
    private final DepartmentsService departmentsService;
    private final PositionsService positionsService;

    public Department_positionsController(Department_positionsService department_positionsService, DepartmentsService departmentsService, PositionsService positionsService) {
        this.department_positionsService = department_positionsService;
        this.departmentsService = departmentsService;
        this.positionsService = positionsService;
    }

    @PostMapping("/department_positions-post")
    public ResponseEntity<?> department_positionsPost(@RequestBody Department_positionsRequestDto body) {
        Departments departments = departmentsService.findById(body.getDepartmentId());
        Positions positions = positionsService.findById(body.getPositionId());
        Department_positions department_positions = new Department_positions(body, departments, positions);

        return ResponseEntity.ok(department_positionsService.save(department_positions));
    }

    @PutMapping("/department_positions-put")
    public ResponseEntity<?> department_positionsPut(@RequestBody Department_positionsRequestDto body) {

        //created_at
        Department_positions department_positions1 = department_positionsService.findById(body.getId());
        body.setCreated_at(department_positions1.getCreated_at());

        Departments departments = departmentsService.findById(body.getDepartmentId());
        Positions positions = positionsService.findById(body.getPositionId());
        Department_positions department_positions = new Department_positions(body, departments, positions);

        return ResponseEntity.ok(department_positionsService.save(department_positions));
    }

    @GetMapping("/department_positions")
    public ResponseEntity<?> department_positionsGet() {
        return ResponseEntity.ok(department_positionsService.findAll());
    }

    @GetMapping("/department_positions/{id}")
    public ResponseEntity<?> department_positionsGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(department_positionsService.findById(id));
    }

    @DeleteMapping("/department_positions-del/{id}")
    public ResponseEntity<?> department_positionsDelOne(@PathVariable Integer id) {
        departmentsService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
