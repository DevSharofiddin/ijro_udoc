package com.ijro_udoc.service;

import com.ijro_udoc.model.Departments;
import com.ijro_udoc.repository.DepartmentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public Departments save(Departments departments) {
        return departmentsRepository.save(departments);
    }
    public List<Departments> findAll() {
        return departmentsRepository.findAll();
    }
    public Departments findById(Integer id) {
        return departmentsRepository.findById(id).get();
    }
    public void delete(Integer id) {
        departmentsRepository.deleteById(id);
    }
}
