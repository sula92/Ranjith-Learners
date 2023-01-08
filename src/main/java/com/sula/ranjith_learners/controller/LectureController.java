package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.model.Lecture;
import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.repository.LectureRepository;
import com.sula.ranjith_learners.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @GetMapping("/lectures/{id}")
    Lecture addStd(@PathVariable int id){
        return lectureRepository.findById(id).get();

    }
/*
    @GetMapping("/lectures/addStd/{id}")
    Lecture getLecturesById(@PathVariable int id){
        return lectureRepository.findById(id).get();
    }*/

    @PostMapping("/lectures")
    Lecture createLecture(@RequestBody Lecture lecture){

        return lectureRepository.save(lecture);
    }

    @GetMapping("/lectures/add/{sid}/{lecid}")
    Student addStudent(@PathVariable int sid, @PathVariable int lecid){
        List<Student> studentList=lectureRepository.findById(lecid).get().getStudents();
        Lecture lecture=lectureRepository.findById(lecid).get();
        Student student=studentRepository.findById(sid).get();
        studentList.add(student);
        lecture.setStudents(studentList);
        lectureRepository.save(lecture);
        return student;
        //lectureRepository.saveStudent(lecid,sid);
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
