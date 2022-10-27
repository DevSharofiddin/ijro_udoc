package com.ijro_udoc.service;

import com.ijro_udoc.model.Offices;
import com.ijro_udoc.repository.OfficesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficesService {

    private final OfficesRepository officesRepository;

    public OfficesService(OfficesRepository officesRepository) {
        this.officesRepository = officesRepository;
    }

    public Offices save(Offices offices) {
        return officesRepository.save(offices);
    }
    public List<Offices> findAll() {
        return officesRepository.findAll();
    }
    public Offices findById(Integer id) {
        return officesRepository.findById(id).get();
    }
    public void delete(Integer id) {
        officesRepository.deleteById(id);
    }
}
