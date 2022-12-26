package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findTopByOrderByIdDesc();

    @Query(value = "SELECT SUM(salary) FROM employee_salary_details WHERE date_of_paid LIKE '2022-12%'", nativeQuery = true)
    Long getTotOtherExpenses();
}
