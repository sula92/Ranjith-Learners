package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.model.Student;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findTopByOrderByIdDesc();
}
