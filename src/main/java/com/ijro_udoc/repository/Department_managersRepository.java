package com.ijro_udoc.repository;

import com.ijro_udoc.model.Department_managers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department_managersRepository extends JpaRepository<Department_managers, Integer> {
}