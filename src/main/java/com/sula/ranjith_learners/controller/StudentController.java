package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable long id) throws ResourceNotFoundException {
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
    public Student saveStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/students")
    public Student editStudent(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) throws ResourceNotFoundException {
        try {
            studentRepository.delete(studentRepository.findById(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Student Does Not Exist");
        }
    }
}
