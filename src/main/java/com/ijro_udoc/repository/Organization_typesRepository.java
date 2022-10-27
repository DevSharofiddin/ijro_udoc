package com.ijro_udoc.repository;

import com.ijro_udoc.model.Organization_types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Organization_typesRepository extends JpaRepository<Organization_types, Integer> {
}