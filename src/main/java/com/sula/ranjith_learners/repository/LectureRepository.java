package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Integer> {

    @Query(value = "INSERT INTO `student_lectures` (`lecture_id`, `student_id`) VALUES (:x, :y)", nativeQuery = true)
    void saveStudent(@Param("x") int x, @Param("y") int y);
}
