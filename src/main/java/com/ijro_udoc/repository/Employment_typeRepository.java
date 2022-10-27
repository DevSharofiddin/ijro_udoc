package com.ijro_udoc.repository;

import com.ijro_udoc.model.Employment_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employment_typeRepository extends JpaRepository<Employment_type, Integer> {
}