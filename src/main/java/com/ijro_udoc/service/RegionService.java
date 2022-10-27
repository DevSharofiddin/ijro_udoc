package com.ijro_udoc.service;

import com.ijro_udoc.model.Region;
import com.ijro_udoc.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }
    public List<Region> findAll() {
        return regionRepository.findAll();
    }
    public Region findById(Integer id) {
        return regionRepository.findById(id).get();
    }
    public void delete(Integer id) {
        regionRepository.deleteById(id);
    }
}
