package com.ijro_udoc.repository;

import com.ijro_udoc.model.Department_positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department_positionsRepository extends JpaRepository<Department_positions, Integer> {
}