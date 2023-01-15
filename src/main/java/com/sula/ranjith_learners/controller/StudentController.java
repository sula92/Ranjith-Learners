package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.CommonDTO;
import com.sula.ranjith_learners.dto.StudentDTO;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.*;
import com.sula.ranjith_learners.model.enums.CivilStatus;
import com.sula.ranjith_learners.model.enums.Gender;
import com.sula.ranjith_learners.model.enums.LicenceType;
import com.sula.ranjith_learners.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ExamRepository examRepository;

    @Autowired
    TrialRepository trialRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    StudentPaymentRepository studentPaymentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return studentRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Such Student");
        }
    }

    @GetMapping("/students/getLast")
    public Student getLastStudent() throws ResourceNotFoundException {
        try {
            return studentRepository.findTopByOrderByIdDesc().get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Such Student In DB");
        }
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody StudentDTO studentDTO){
        Branch branch=branchRepository.findById(studentDTO.getBranchId()).get();
        Exam exam=examRepository.findById(studentDTO.getExamId()).get();
        Trial trial=trialRepository.findById(studentDTO.getTrialId()).get();
        Student student=Student.builder()
                .address(studentDTO.getAddress())
                .branch(branch)
                .age(studentDTO.getAge())
                .civilStatus(CivilStatus.valueOf(studentDTO.getCivilStatus()))
                .contact(studentDTO.getContact())
                .email(studentDTO.getEmail())
                .dateOfJoined(studentDTO.getDateOfJoined())
                .gender(Gender.valueOf(studentDTO.getGender()))
                .name(studentDTO.getName())
                .isLicenseIssued(studentDTO.getIsLicenseIssued())
                .licenceType(LicenceType.valueOf(studentDTO.getLicenceType()))
                .exam(exam)
                .trial(trial)
                .build();
        return studentRepository.save(student);
    }

    @PutMapping("/students")
    public Student editStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) throws ResourceNotFoundException {
        try {
            studentRepository.delete(studentRepository.findById(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Student Does Not Exist");
        }
    }

    @GetMapping("/students/gotlicens")
    CommonDTO getAllStudentsGotLicens(){

        Map<String,String> stringStringMap=new HashMap<>();

        String x= String.valueOf(studentRepository.findAll().stream()
                .filter(student -> student.getIsLicenseIssued().equalsIgnoreCase("yes"))
                .count());

        String y= String.valueOf(studentRepository.findAll().stream()
                .filter(student -> student.getIsLicenseIssued().equalsIgnoreCase("pending"))
                .count());

        stringStringMap.put("yes",x);
        stringStringMap.put("no",y);

        return CommonDTO.builder()
                .stringMap(stringStringMap).build();
    }

    @GetMapping("/students/pay")
    List<StudentPayment> getAllStudentsPayments(){

        return studentPaymentRepository.findAll();
    }

}
