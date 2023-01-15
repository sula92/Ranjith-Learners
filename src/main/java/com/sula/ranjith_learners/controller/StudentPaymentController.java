package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.StudentPaymentDTO;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.StudentPayment;
import com.sula.ranjith_learners.repository.StudentPaymentRepository;
import com.sula.ranjith_learners.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Transactional
public class StudentPaymentController {

    @Autowired
    StudentPaymentRepository studentPaymentRepository;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/student_payments")
    private StudentPayment saveStudentPayment(@RequestBody StudentPaymentDTO studentPaymentDTO) throws ResourceNotFoundException {
        try {
            StudentPayment payment=StudentPayment.builder()
                    .paymentDetail(studentPaymentDTO.getPaymentDetail())
                    .dateOfDue(studentPaymentDTO.getDateOfDue())
                    .student(studentRepository.findById(studentPaymentDTO.getStudentId()).get())
                    .dateOfSettled(studentPaymentDTO.getDateOfSettled())
                    .fine(studentPaymentDTO.getFine())
                    .amount(studentPaymentDTO.getAmount())
                    .id(studentPaymentDTO.getId())
                    .build();
                    studentPaymentRepository.save(payment);
            return payment;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Student Does Not Exist");
        }

    }

    @PutMapping("/student_payments/{id}")
    private StudentPayment editStudentPayment(@PathVariable long id, @RequestBody StudentPaymentDTO studentPaymentDTO) throws ResourceNotFoundException {
        try {
            studentPaymentRepository.findById(id).get();
            StudentPayment payment=StudentPayment.builder()
                    .paymentDetail(studentPaymentDTO.getPaymentDetail())
                    .dateOfDue(studentPaymentDTO.getDateOfDue())
                    .student(studentRepository.findById(studentPaymentDTO.getStudentId()).get())
                    .dateOfSettled(studentPaymentDTO.getDateOfSettled())
                    .fine(studentPaymentDTO.getFine())
                    .amount(studentPaymentDTO.getAmount())
                    .id(studentPaymentDTO.getId())
                    .build();
            studentPaymentRepository.save(payment);
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

    @GetMapping("/student_payments/student/{stdId}")
    List<StudentPayment> getAllPayDetailsByStdId(@PathVariable int id){
        return studentPaymentRepository.findAll().stream()
                .filter(studentPayment -> studentPayment.getStudent().getId()==id)
                .collect(Collectors.toList());
    }

    @GetMapping("/student_payments/date/{date}")
    List<StudentPayment> getAllPaymentsByDate(@PathVariable Date date){
        return studentPaymentRepository.findAll().stream()
                .filter(studentPayment -> studentPayment.getDateOfSettled().equals(date))
                .collect(Collectors.toList());
    }

    @GetMapping("/student_payments/due")
    List<StudentPayment> getAllDuePaymentsByDate(){
        return studentPaymentRepository.findAll().stream()
                .filter(studentPayment -> studentPayment.getDateOfSettled().before(new Date(System.currentTimeMillis())))
                .collect(Collectors.toList());
    }


}
