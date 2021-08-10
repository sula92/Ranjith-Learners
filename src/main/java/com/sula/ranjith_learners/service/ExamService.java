package com.sula.ranjith_learners.service;

import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    public Exam saveExam(Exam exam){
        Exam lastExam=examRepository.findTopByOrderByIdDesc().get();
        String lastId=lastExam.getId();
        String newId;
        int lId= Integer.parseInt(lastId.replace("E",""));
        newId="E"+(lId+1);
        exam.setId(newId);
        return examRepository.save(exam);
    }
}
