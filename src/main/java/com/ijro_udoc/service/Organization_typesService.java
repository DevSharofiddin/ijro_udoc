package com.ijro_udoc.service;

import com.ijro_udoc.model.Organization_types;
import com.ijro_udoc.repository.Organization_typesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Organization_typesService {

    private final Organization_typesRepository organization_typesRepository;

    public Organization_typesService(Organization_typesRepository organization_typesRepository) {
        this.organization_typesRepository = organization_typesRepository;
    }

    public Organization_types save(Organization_types organization_types) {
        return organization_typesRepository.save(organization_types);
    }
    public List<Organization_types> findAll() {
        return organization_typesRepository.findAll();
    }
    public Organization_types findById(Integer id) {
        return organization_typesRepository.findById(id).get();
    }
    public void delete(Integer id) {
        organization_typesRepository.deleteById(id);
    }
}
