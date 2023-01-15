package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.EmployeeSalaryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalaryDetail, Integer> {

    @Query(value = "SELECT SUM(salary) FROM employee_salary_details", nativeQuery = true)
    Long getTotSal();
}
