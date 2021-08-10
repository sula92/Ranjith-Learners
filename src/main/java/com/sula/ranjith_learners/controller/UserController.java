package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.User;
import com.sula.ranjith_learners.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id) throws ResourceNotFoundException {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("User is Not Exist in the DB");
        }
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    @PutMapping("/users")
    public User editUser(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) throws ResourceNotFoundException {
        try {
            userRepository.delete(userRepository.findById(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Such User In The DB To Delete");
        }
    }


}
