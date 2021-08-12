package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Employee;
import com.sula.ranjith_learners.repository.EmployeeRepository;
import com.sula.ranjith_learners.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Transactional
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) throws ResourceNotFoundException {
        try {
            return employeeRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Employee");
        }
    }

    @GetMapping("/employees/getLast")
    public Employee getLastEmployee() throws ResourceNotFoundException {
        try {
            return employeeRepository.findTopByOrderByIdDesc().get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Employees are Available In The DB");
        }
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody @Valid Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees")
    public Employee editEmployee(@RequestBody @Valid Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable long id) throws ResourceNotFoundException {
        try {
            employeeRepository.delete(employeeRepository.findById(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Such Employee To Delete");
        }
    }


}
