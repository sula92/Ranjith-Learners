package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.ExamDTO;
import com.sula.ranjith_learners.dto.reports.ExamReport;
import com.sula.ranjith_learners.dto.reports.ExamReportById;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.repository.ExamRepository;
import com.sula.ranjith_learners.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(
        value = "/api",
        produces = "application/json")
@Transactional

@CrossOrigin(origins = {
        "*"

},
        allowedHeaders = "*",

        maxAge = 15 * 60,
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class ExamController {

    @Autowired
    ExamRepository examRepository;

    @Autowired
    ExamService examService;

    @GetMapping("/exams")
    public List<Exam> getAllExams(){
        return examRepository.findAll();
    }

    @GetMapping("/exams/getLast")
    public Exam getLastExam(){
        return examRepository.findTopByOrderByIdDesc().get();
    }

    @GetMapping("/exams/{id}")
    public Exam getExamById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return examRepository.findById(id).get();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Exam");
        }

    }

    @GetMapping("/exams/report/{id}")
    public List<ExamReportById> getExamByIdReport(@PathVariable String id) throws ResourceNotFoundException {
        try {
            return examRepository.getExamByIdReport(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Record");
        }

    }

    @GetMapping("/exams/report")
    public List<ExamReport> getExamReport(@PathVariable String id) throws ResourceNotFoundException {
        try {
            return examRepository.getExamReport();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Record");
        }

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/exams")
    public Exam saveExam(@RequestBody @Valid Exam exam){
        return examService.saveExam(exam);
    }

    @PostMapping("/test")

    public Exam test(@RequestBody ExamDTO examDTO){

        Exam exam= new Exam();
        exam.setId(1);
        exam.setDate(Date.valueOf(LocalDate.now()));
        exam.setVenue("sss");
        return exam;
    }

    @PutMapping("/exams")
    public Exam editExam(@RequestBody @Valid Exam exam){

       Exam exam1=examRepository.findById(exam.getId()).get();
              // exam1.builder().date(exam.getDate()).venue(exam.getVenue()).time(exam.getTime()).build();
        return examRepository.save(exam);
    }

    @DeleteMapping("/exams")
    public void deleteExam(@RequestParam int id){
        examRepository.deleteById(id);
    }

}
