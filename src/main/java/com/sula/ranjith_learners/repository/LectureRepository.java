package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {
}
