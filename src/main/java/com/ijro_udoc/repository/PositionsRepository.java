package com.ijro_udoc.repository;

import com.ijro_udoc.model.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionsRepository extends JpaRepository<Positions, Integer> {
}