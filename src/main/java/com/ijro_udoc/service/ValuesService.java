package com.ijro_udoc.service;

import com.ijro_udoc.model.Values;
import com.ijro_udoc.repository.ValuesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValuesService {

    private final ValuesRepository valuesRepository;

    public ValuesService(ValuesRepository valuesRepository) {
        this.valuesRepository = valuesRepository;
    }

    public Values save(Values values) {
        return valuesRepository.save(values);
    }
    public List<Values> findAll() {
        return valuesRepository.findAll();
    }
    public Values findById(Integer id) {
        return valuesRepository.findById(id).get();
    }
    public void delete(Integer id) {
        valuesRepository.deleteById(id);
    }
}
