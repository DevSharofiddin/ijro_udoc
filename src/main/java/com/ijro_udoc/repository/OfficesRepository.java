package com.ijro_udoc.repository;

import com.ijro_udoc.model.Offices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficesRepository extends JpaRepository<Offices, Integer> {
}