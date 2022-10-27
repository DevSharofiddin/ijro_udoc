package com.ijro_udoc.service;

import com.ijro_udoc.model.Employees;
import com.ijro_udoc.repository.EmployeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public Employees save(Employees employees) {
        return employeesRepository.save(employees);
    }
    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }
    public Employees findById(Long id) {
        return employeesRepository.findById(id).get();
    }
    public void delete(Long id) {
        employeesRepository.deleteById(id);
    }
}
