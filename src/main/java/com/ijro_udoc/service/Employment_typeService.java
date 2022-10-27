package com.ijro_udoc.service;

import com.ijro_udoc.model.Employment_type;
import com.ijro_udoc.repository.Employment_typeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employment_typeService {

    private final Employment_typeRepository employment_typeRepository;

    public Employment_typeService(Employment_typeRepository employment_typeRepository) {
        this.employment_typeRepository = employment_typeRepository;
    }

    public Employment_type save(Employment_type employment_type) {
        return employment_typeRepository.save(employment_type);
    }
    public List<Employment_type> findAll() {
        return employment_typeRepository.findAll();
    }
    public Employment_type findById(Integer id) {
        return employment_typeRepository.findById(id).get();
    }
    public void delete(Integer id) {
        employment_typeRepository.deleteById(id);
    }
}
