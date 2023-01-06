package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.model.Lecture;
import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.repository.LectureRepository;
import com.sula.ranjith_learners.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Arrays;
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
public class LectureController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/lectures")
    List<Lecture> getLectures(){
       return lectureRepository.findAll();
    }

    @PostMapping("/lectures")
    Lecture createLecture(@RequestBody Lecture lecture){

        return lectureRepository.save(lecture);
    }

    @PostMapping("/lectures/{sid}/{lecid}")
    Lecture addStudent(@PathVariable long sid, @PathVariable int lecid){
        Lecture lecture=lectureRepository.findById(lecid).get();
        Student student=studentRepository.findById(sid).get();
        lecture.setStudents(Arrays.asList(student));
        return lectureRepository.save(lecture);
    }

    @PutMapping("/lectures/{id}")
    Lecture editLecture(@PathVariable int id, @RequestBody Lecture lecture){
        lectureRepository.findById(id).get();
        return lectureRepository.save(lecture);
    }

    @DeleteMapping("/lectures/{id}")
    void deleteLecture(@PathVariable int id){
        lectureRepository.findById(id).get();
        lectureRepository.deleteById(id);
    }
}
