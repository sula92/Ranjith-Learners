package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.StudentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPaymentRepository extends JpaRepository<StudentPayment,Long> {
}
