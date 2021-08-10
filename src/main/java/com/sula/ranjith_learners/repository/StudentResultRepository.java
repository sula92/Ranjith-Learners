package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.dto.reports.ExamReport;
import com.sula.ranjith_learners.dto.reports.TrialReport;
import com.sula.ranjith_learners.model.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentResultRepository extends JpaRepository<StudentResult, String> {

    @Query(value = "select sr.exam_id as id, ex.date, ex.time, ex.venue,  count(sr.student_id) as totalParticipants, COUNT(CASE WHEN sr.examResult = 'PASS' THEN examResult END) as totalPass, COUNT(CASE WHEN sr.examResult = 'FAIL' THEN examResult END) as totalFail from results sr INNER JOIN exams ex ON sr.exam_id=ex.id group by sr.exam_id", nativeQuery = true)
    List<ExamReport> getExamReport();

    @Query(value = "select sr.trial_id as id, tr.date, tr.time, tr.venue,  count(sr.student_id) as totalParticipants, COUNT(CASE WHEN sr.trialResult = 'PASS' THEN trialResult END) as totalPass, COUNT(CASE WHEN sr.trialResult = 'FAIL' THEN trialResult END) as totalFail from results sr INNER JOIN trials tr ON sr.trial_id=tr.id group by sr.trial_id", nativeQuery = true)
    List<TrialReport> getTrialReport();
}
