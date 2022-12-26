package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPaymentRepository extends JpaRepository<StudentPayment,Long> {

    @Query(value = "SELECT SUM(amount) FROM student_payments WHERE dateOfSettled LIKE '2022-12%'", nativeQuery = true)
    Long getStudentMonthlyIncome();

    @Query(value = "SELECT SUM(amount) FROM student_payments WHERE NOT dateOfSettled LIKE '2022-12-01%'", nativeQuery = true)
    Long getStudentDailyIncome();
}
