package com.ijro_udoc.service;

import com.ijro_udoc.model.Department_managers;
import com.ijro_udoc.repository.Department_managersRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Department_managersService {

    private final Department_managersRepository department_managersRepository;

    public Department_managersService(Department_managersRepository department_managersRepository) {
        this.department_managersRepository = department_managersRepository;
    }

    public Department_managers save(Department_managers department_managers) {
        return department_managersRepository.save(department_managers);
    }
    public List<Department_managers> findAll() {
        return department_managersRepository.findAll();
    }
    public Department_managers findById(Integer id) {
        return department_managersRepository.findById(id).get();
    }
    public void delete(Integer id) {
        department_managersRepository.deleteById(id);
    }
}
