package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {

    @Query("select sp from StudentProfile sp left join fetch sp.student where sp.student.id=:id")
    StudentProfile getStudentProfileByStudentId(@Param("id") Long id);
}
