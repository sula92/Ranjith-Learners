package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.reports.ExamReport;
import com.sula.ranjith_learners.dto.reports.TrialReport;
import com.sula.ranjith_learners.repository.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/results")
@Transactional
public class StudentResultController {

    @Autowired
    StudentResultRepository studentResultRepository;

    @GetMapping("/exam")
    public List<ExamReport> getExamReport(){
        return studentResultRepository.getExamReport();
    }

    @GetMapping("/exam/{id}")
    public List<ExamReport> getExamReportById(@PathVariable String id){

        return studentResultRepository.getExamReportById(id);
    }

    @GetMapping("/trial")
    public List<TrialReport> getTrialReport(){
        return studentResultRepository.getTrialReport();
    }

}
