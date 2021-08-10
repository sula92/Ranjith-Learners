package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.reports.ExamReport;
import com.sula.ranjith_learners.dto.reports.TrialReport;
import com.sula.ranjith_learners.repository.StudentRepository;
import com.sula.ranjith_learners.repository.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class StudentResultController {

    @Autowired
    StudentResultRepository studentResultRepository;

    @GetMapping("/results/exam")
    public List<ExamReport> getExamReport(){
        return studentResultRepository.getExamReport();
    }

    @GetMapping("/results/trial")
    public List<TrialReport> getTrialReport(){
        return studentResultRepository.getTrialReport();
    }

}
