package com.ijro_udoc.repository;

import com.ijro_udoc.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
}