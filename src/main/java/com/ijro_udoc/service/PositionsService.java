package com.ijro_udoc.service;

import com.ijro_udoc.model.Positions;
import com.ijro_udoc.repository.PositionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionsService {

    public final PositionsRepository positionsRepository;

    public PositionsService(PositionsRepository positionsRepository) {
        this.positionsRepository = positionsRepository;
    }

    public Positions save(Positions positions) {
        return positionsRepository.save(positions);
    }
    public List<Positions> findAll() {
        return positionsRepository.findAll();
    }
    public Positions findById(Integer id) {
        return positionsRepository.findById(id).get();
    }
    public void delete(Integer id) {
        positionsRepository.deleteById(id);
    }
}
