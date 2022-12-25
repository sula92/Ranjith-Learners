package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.model.People;
import com.sula.ranjith_learners.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/")
@RestController
@CrossOrigin
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @GetMapping("/people")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<People> getPeople(){
        return peopleService.getPeolple();
    }

    @GetMapping("/people/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public People getPeople(@PathVariable int id){
          return peopleService.getPeolpleById(id);
    }


}
