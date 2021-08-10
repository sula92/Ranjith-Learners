package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.dto.reports.ExamReport;
import com.sula.ranjith_learners.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam,String> {

    Optional<Exam> findTopByOrderByIdDesc();

}
