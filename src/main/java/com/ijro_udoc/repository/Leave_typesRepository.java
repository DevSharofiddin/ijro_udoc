package com.ijro_udoc.repository;

import com.ijro_udoc.model.Leave_types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Leave_typesRepository extends JpaRepository<Leave_types, Integer> {
}