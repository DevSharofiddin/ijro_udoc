package com.ijro_udoc.controller;

import com.ijro_udoc.model.Department_managers;
import com.ijro_udoc.model.Departments;
import com.ijro_udoc.model.Users;
import com.ijro_udoc.model.dto.Department_managersRequestDto;
import com.ijro_udoc.service.Department_managersService;
import com.ijro_udoc.service.DepartmentsService;
import com.ijro_udoc.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Department_managersController {

    private final Department_managersService department_managersService;
    private final DepartmentsService departmentsService;
    private final UsersService usersService;

    public Department_managersController(Department_managersService department_managersService, DepartmentsService departmentsService, UsersService usersService) {
        this.department_managersService = department_managersService;
        this.departmentsService = departmentsService;
        this.usersService = usersService;
    }

    @PostMapping("/department_managers-post")
    public ResponseEntity<?> department_managersPost(@RequestBody Department_managersRequestDto body) {
        Departments departments = departmentsService.findById(body.getDepartmentId());
        Users users = usersService.findById(body.getUserId());
        Department_managers department_managers = new Department_managers(body, departments, users);
        return ResponseEntity.ok(department_managersService.save(department_managers));
    }

    @PutMapping("/department_managers-put")
    public ResponseEntity<?> department_managersPut(@RequestBody Department_managersRequestDto body) {

        //created_at
        Department_managers department_managers1 = department_managersService.findById(body.getId());
        body.setCreated_at(department_managers1.getCreated_at());

        Departments departments = departmentsService.findById(body.getDepartmentId());
        Users users = usersService.findById(body.getUserId());
        Department_managers department_managers = new Department_managers(body, departments, users);
        return ResponseEntity.ok(department_managersService.save(department_managers));
    }

    @GetMapping("/department_managers")
    public ResponseEntity<?> department_managersGet() {
        return ResponseEntity.ok(department_managersService.findAll());
    }

    @GetMapping("/department_managers/{id}")
    public ResponseEntity<?> department_managersGetOne(@PathVariable Integer id) {
        return ResponseEntity.ok(department_managersService.findById(id));
    }

    @DeleteMapping("/department_managers-del/{id}")
    public ResponseEntity<?> department_managersDelOne(@PathVariable Integer id) {
        departmentsService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
