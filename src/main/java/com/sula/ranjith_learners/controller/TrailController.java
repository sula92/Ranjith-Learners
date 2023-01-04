package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Trial;
import com.sula.ranjith_learners.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

//import sun.misc.Resource;

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
public class TrailController {

    @Autowired
    TrialRepository trialRepository;

    @GetMapping("/trials")
    public List<Trial> getAllTrial(){
        return trialRepository.findAll();
    }

    @GetMapping("/trials/{id}")
    public Trial getTrialById(@PathVariable int id) throws ResourceNotFoundException {

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
    public void deleteTrial(@PathVariable int id){
        trialRepository.deleteById(id);
    }

}
