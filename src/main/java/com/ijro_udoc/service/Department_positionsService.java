package com.ijro_udoc.service;

import com.ijro_udoc.model.Department_positions;
import com.ijro_udoc.repository.Department_positionsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Department_positionsService {

    private final Department_positionsRepository department_positionsRepository;

    public Department_positionsService(Department_positionsRepository department_positionsRepository) {
        this.department_positionsRepository = department_positionsRepository;
    }

    public Department_positions save(Department_positions department_positions) {
        return department_positionsRepository.save(department_positions);
    }
    public List<Department_positions> findAll() {
        return department_positionsRepository.findAll();
    }
    public Department_positions findById(Integer id) {
        return department_positionsRepository.findById(id).get();
    }
    public void delete(Integer id) {
        department_positionsRepository.deleteById(id);
    }
}
