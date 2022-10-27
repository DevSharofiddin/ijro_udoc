package com.ijro_udoc.service;

import com.ijro_udoc.model.Leave_types;
import com.ijro_udoc.repository.Leave_typesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Leave_tupesService{

    private final Leave_typesRepository leave_typesRepository;

    public Leave_tupesService(Leave_typesRepository leave_typesRepository) {
        this.leave_typesRepository = leave_typesRepository;
    }

    public Leave_types save(Leave_types leave_types) {
        return leave_typesRepository.save(leave_types);
    }
    public List<Leave_types> findAll() {
        return leave_typesRepository.findAll();
    }
    public Leave_types findById(Integer id) {
        return leave_typesRepository.findById(id).get();
    }
    public void delete(Integer id) {
        leave_typesRepository.deleteById(id);
    }
}
