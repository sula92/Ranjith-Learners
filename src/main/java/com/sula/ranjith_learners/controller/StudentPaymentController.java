package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.model.StudentPayment;
import com.sula.ranjith_learners.repository.StudentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class StudentPaymentController {

    @Autowired
    StudentPaymentRepository studentPaymentRepository;

    @PostMapping("/student_payments")
    private StudentPayment saveStudentPayment(@RequestBody StudentPayment studentPayment) throws ResourceNotFoundException {
        try {
            StudentPayment payment=studentPaymentRepository.save(studentPayment);
            return payment;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Student Does Not Exist");
        }

    }

    @GetMapping("/student_payments")
    public List<StudentPayment> getAllExams(){
        return studentPaymentRepository.findAll();
    }

    @DeleteMapping("/student_payments/{id}")
    public void deletePayment(@PathVariable Long id) throws ResourceNotFoundException {
        try {
            studentPaymentRepository.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Student Does Not Exist");
        }

    }


}
