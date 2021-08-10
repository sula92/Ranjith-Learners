package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Employee;
import com.sula.ranjith_learners.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findTopByOrderByIdDesc();
}
