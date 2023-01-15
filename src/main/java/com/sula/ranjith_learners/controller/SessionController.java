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
public class SessionController {

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/session")
    List<Lecture> getLectures(){
       return lectureRepository.findAll();
    }

    @GetMapping("/session/{id}")
    Lecture addStd(@PathVariable int id){
        return lectureRepository.findById(id).get();

    }
/*
    @GetMapping("/lectures/addStd/{id}")
    Lecture getLecturesById(@PathVariable int id){
        return lectureRepository.findById(id).get();
    }*/

    @PostMapping("/session")
    Lecture createLecture(@RequestBody Lecture lecture){

        return lectureRepository.save(lecture);
    }

    @GetMapping("/session/add/{sid}/{lecid}")
    Student addStudent(@PathVariable String sid, @PathVariable int lecid){
        int n=sid.indexOf("-");
        String stdId=sid.substring(0,n);
        //System.out.println("XXXXXXXXXXxx0"+stdId);
        List<Student> studentList=lectureRepository.findById(lecid).get().getStudents();
        Lecture lecture=lectureRepository.findById(lecid).get();
        Student student=studentRepository.findById(Integer.valueOf(stdId)).get();
        studentList.add(student);
        lecture.setStudents(studentList);
        lectureRepository.save(lecture);
        return student;
        //lectureRepository.saveStudent(lecid,sid);
    }

    @PutMapping("/session/{id}")
    Lecture editLecture(@PathVariable int id, @RequestBody Lecture lecture){
        lectureRepository.findById(id).get();
        return lectureRepository.save(lecture);
    }

    @DeleteMapping("/session/{id}")
    void deleteLecture(@PathVariable int id){
        lectureRepository.findById(id).get();
        lectureRepository.deleteById(id);
    }
}
