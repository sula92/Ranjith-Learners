package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.dto.reports.ExamReport;
import com.sula.ranjith_learners.dto.reports.ExamReportById;
import com.sula.ranjith_learners.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Integer> {

    Optional<Exam> findTopByOrderByIdDesc();

    @Query(value = "select s.id as studentId, s.name, s.licenceType, s.age, r.examResult   from students s INNER JOIN results r ON s.id=r.student_id where r.exam_id= :sid", nativeQuery = true)
    List<ExamReportById> getExamByIdReport(@Param("sid") String sid);

    @Query(value = "select sr.exam_id as id, ex.date, ex.time, ex.venue,  count(sr.student_id) as totalParticipants, COUNT(CASE WHEN sr.examResult = 'PASS' THEN examResult END) as totalPass, COUNT(CASE WHEN sr.examResult = 'FAIL' THEN examResult END) as totalFail from results sr INNER JOIN exams ex ON sr.exam_id=ex.id group by sr.exam_id", nativeQuery = true)
    List<ExamReport> getExamReport();
}
