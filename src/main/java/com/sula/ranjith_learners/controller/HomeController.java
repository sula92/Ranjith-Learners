package com.sula.ranjith_learners.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/home")
    public String gethome()
    {
        return "<h1>Hello World</h1>";
    }

}
