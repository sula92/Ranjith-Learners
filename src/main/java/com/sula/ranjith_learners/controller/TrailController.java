package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Exam;
import com.sula.ranjith_learners.model.Trial;
import com.sula.ranjith_learners.repository.TrialRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Resource;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class TrailController {

    @Autowired
    TrialRepository trialRepository;

    @GetMapping("/trials")
    public List<Trial> getAllTrial(){
        return trialRepository.findAll();
    }

    @GetMapping("/trials/{id}")
    public Trial getTrialById(@PathVariable long id) throws ResourceNotFoundException {

        try {
            return trialRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Such Trial in the DB");
        }
    }

    @GetMapping("/trials/getLast")
    public Trial getLastExam() throws ResourceNotFoundException {
        try {
            return trialRepository.findTopByOrderByIdDesc().get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Record in the DB");
        }
    }

    @PostMapping("/trials")
    public Trial saveTrial(@RequestBody @Valid Trial trial){
        return trialRepository.save(trial);
    }

    @PutMapping("/trials")
    public Trial editTrial(@RequestBody Trial trial){
        return trialRepository.save(trial);
    }

    @DeleteMapping("/trials/{id}")
    public void deleteTrial(@PathVariable long id){
        trialRepository.deleteById(id);
    }

}
