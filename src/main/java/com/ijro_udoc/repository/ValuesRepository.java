package com.ijro_udoc.repository;

import com.ijro_udoc.model.Values;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValuesRepository extends JpaRepository<Values, Integer> {
}

