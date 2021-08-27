package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.model.StudentProfile;
import com.sula.ranjith_learners.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
@Transactional
public class StudentProfileController {

    @Autowired
    StudentProfileRepository studentProfileRepository;

    @GetMapping("/studentprofile/{stdId}")
    private StudentProfile getProfileByStudentId(@PathVariable long id){
        return studentProfileRepository.getStudentProfileByStudentEqualsAndProfileIdIsNotNull(id);


    }
}
