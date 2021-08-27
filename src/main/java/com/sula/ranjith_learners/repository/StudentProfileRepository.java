package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {


    StudentProfile getStudentProfileByStudentEqualsAndProfileIdIsNotNull(Long id);
}
