package com.ijro_udoc.controller;

import com.ijro_udoc.model.Departments;
import com.ijro_udoc.model.Users;
import com.ijro_udoc.model.dto.DepartmentsRequestDto;
import com.ijro_udoc.service.DepartmentsService;
import com.ijro_udoc.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DepartmentsController {

    private final DepartmentsService departmentsService;
    private final UsersService usersService;

    public DepartmentsController(DepartmentsService departmentsService, UsersService usersService) {
        this.departmentsService = departmentsService;
        this.usersService = usersService;
    }

    @PostMapping("/departments-post")
    public ResponseEntity<?> departmentsPost(@RequestBody DepartmentsRequestDto body) {

        Users usersCurator = usersService.findById(body.getCuratorId());
        Users usersHead = usersService.findById(body.getHeadId());

        Departments departments1 = new Departments(body, usersCurator, usersHead);

        return ResponseEntity.ok(departmentsService.save(departments1));
    }

    @PutMapping("/departments-put")
    public ResponseEntity<?> departmentsPut(@RequestBody DepartmentsRequestDto body) {

        //created_at
        Departments departments = departmentsService.findById(body.getId());
        body.setCreated_at(departments.getCreated_at());

        Users usersCurator = usersService.findById(body.getCuratorId());
        Users usersHead = usersService.findById(body.getHeadId());
        Departments departments1 = new Departments(body, usersCurator, usersHead);

        return ResponseEntity.ok(departmentsService.save(departments1));
    }

    @GetMapping("/departments")
    public ResponseEntity<?> departmentsGet() {
        return ResponseEntity.ok(departmentsService.findAll());
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> departmentsGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentsService.findById(id));
    }

    @DeleteMapping("/departments-del/{id}")
    public ResponseEntity<?> departmentsDelOne(@PathVariable Integer id) {
        departmentsService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

}
