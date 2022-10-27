package com.ijro_udoc.controller;

import com.ijro_udoc.model.*;
import com.ijro_udoc.model.dto.EmployeesRequestDto;
import com.ijro_udoc.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class EmployeesController {

    private final EmployeesService employeesService;
    private final DepartmentsService departmentsService;
    private final Employment_typeService employment_typeService;
    private final OfficesService officesService;
    private final UsersService usersService;
    private final PositionsService positionsService;

    public EmployeesController(EmployeesService employeesService, DepartmentsService departmentsService, Employment_typeService employment_typeService, OfficesService officesService, UsersService usersService, PositionsService positionsService) {
        this.employeesService = employeesService;
        this.departmentsService = departmentsService;
        this.employment_typeService = employment_typeService;
        this.officesService = officesService;
        this.usersService = usersService;
        this.positionsService = positionsService;
    }

    @PostMapping("/employees-post")
    public ResponseEntity<?> employeesPost(@RequestBody EmployeesRequestDto body) {

        //hired_date
        LocalDate localDate = LocalDate.now();
        body.setHired_date(localDate);

        //fired_date
        body.setFired_date(null);

        Departments departments = departmentsService.findById(body.getDepartmentId());
        Employment_type employment_type = employment_typeService.findById(body.getEmployment_typeId());
        Positions positions = positionsService.findById(body.getPositionId());
        Offices offices = officesService.findById(body.getOfficeId());
        Users users = null;
        if (body.getUserId() != null)
            users = usersService.findById(body.getUserId());
        Employees employees = new Employees(body, departments,employment_type, offices, users, positions);
        return ResponseEntity.ok(employeesService.save(employees));
    }

    @PutMapping("/employees-put")
    public ResponseEntity<?> employeesPut(@RequestBody EmployeesRequestDto body) {

        LocalDate now = LocalDate.now();

        //hired_date
        Employees employees2 = employeesService.findById(body.getId());
        body.setHired_date(employees2.getHired_date());

        //fired_date
        if (body.getHired_date() != null)
            body.setHired_date(now);

        Employment_type employment_type = employment_typeService.findById(body.getEmployment_typeId());
        Offices offices = officesService.findById(body.getOfficeId());
        Departments departments = departmentsService.findById(body.getDepartmentId());
        Positions positions = positionsService.findById(body.getPositionId());
        Users users = null;
        if (body.getUserId() != null)
            users = usersService.findById(body.getUserId());

        //created_at
        Employees employees1 = employeesService.findById(body.getId());
        body.setCreated_at(employees1.getCreated_at());

        Employees employees = new Employees(body, departments,employment_type, offices, users, positions);
        return ResponseEntity.ok(employeesService.save(employees));
    }

    @GetMapping("/employees")
    public ResponseEntity<?> employeesGet() {
        return ResponseEntity.ok(employeesService.findAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> employeesGetOne(@PathVariable Long id) {
        return ResponseEntity.ok(employeesService.findById(id));
    }

    @DeleteMapping("/employees-del/{id}")
    public ResponseEntity<?> employeesDelOne(@PathVariable Long id) {
        employeesService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
