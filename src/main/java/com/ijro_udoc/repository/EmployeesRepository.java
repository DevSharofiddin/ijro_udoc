package com.ijro_udoc.repository;
import com.ijro_udoc.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
}

