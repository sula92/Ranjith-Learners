package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.model.StudentProfile;
import com.sula.ranjith_learners.repository.StudentProfileRepository;
import com.sula.ranjith_learners.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class StudentProfileController {

    @Autowired
    StudentProfileRepository studentProfileRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/studentprofiles")
    private List<StudentProfile> getProfileByStudentId(){
        return studentProfileRepository.findAll();


    }

    @GetMapping("/studentprofiles/{id}")
    private StudentProfile getProfileByStudentId(@PathVariable long id){
        return studentProfileRepository.getStudentProfileByStudentId(id);


    }

    @DeleteMapping("/studentprofiles/{id}")
    private void DeleteProfileByStudentId(@PathVariable long id){
        StudentProfile studentProfile= studentProfileRepository.getStudentProfileByStudentId(id);
        int pid=studentProfile.getProfileId();
        studentProfileRepository.deleteById(pid);

    }
}

