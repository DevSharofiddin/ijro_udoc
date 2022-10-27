package com.ijro_udoc.service;

import com.ijro_udoc.model.Organizations;
import com.ijro_udoc.repository.OrganizationsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationsRepository organizationsRepository;

    public OrganizationService(OrganizationsRepository organizationsRepository) {
        this.organizationsRepository = organizationsRepository;
    }

    public Organizations save(Organizations organizations) {
        return organizationsRepository.save(organizations);
    }
    public List<Organizations> findAll() {
        return organizationsRepository.findAll();
    }
    public Organizations findById(Integer id) {
        return organizationsRepository.findById(id).get();
    }
    public void delete(Integer id) {
        organizationsRepository.deleteById(id);
    }
}
