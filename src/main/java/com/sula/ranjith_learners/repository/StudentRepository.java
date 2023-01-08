package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findTopByOrderByIdDesc();

    @Query(value = "SELECT SUM(amount) FROM students WHERE isLicenseIssued LIKE 'y%'", nativeQuery = true)
    Long getStudentMonthlyIncome();
}
