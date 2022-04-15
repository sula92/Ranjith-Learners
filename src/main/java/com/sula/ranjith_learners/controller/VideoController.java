package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.repository.ExamRepository;
import com.sula.ranjith_learners.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/videos")
@Transactional
public class VideoController {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ExamService examService;

    @GetMapping("/videos")
    public List<Exam> getAllVideos(){
        return examRepository.findAll();
    }

    @GetMapping("/exams/getLast")
    public Exam getLastExam(){
        return examRepository.findTopByOrderByIdDesc().get();
    }

    @GetMapping("/exams/{id}")
    public Exam getExamById(@PathVariable String id) throws ResourceNotFoundException {
        try {
            return examRepository.findById(id).get();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Exam");
        }

    }

    @PostMapping("/exams")
    public Exam saveExam(@RequestBody @Valid Exam exam){
        return examService.saveExam(exam);
    }

    @PutMapping("/exams")
    public Exam editExam(@RequestBody @Valid Exam exam){
        return examRepository.save(exam);
    }

    @DeleteMapping("/exams/{id}")
    public void deleteExam(@PathVariable String id){
        examRepository.deleteById(id);
    }



}
