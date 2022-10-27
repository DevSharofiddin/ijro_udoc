package com.ijro_udoc.repository;

import com.ijro_udoc.model.Organizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organizations, Integer> {
}