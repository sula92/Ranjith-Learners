package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.EmployeeSalDTO;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Employee;
import com.sula.ranjith_learners.model.EmployeeSalaryDetail;
import com.sula.ranjith_learners.repository.EmployeeRepository;
import com.sula.ranjith_learners.repository.EmployeeSalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeSalaryRepository employeeSalaryRepository;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws ResourceNotFoundException {
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
    public void deleteEmployee(@PathVariable int id) throws ResourceNotFoundException {
        try {
            employeeRepository.delete(employeeRepository.findById(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("No Such Employee To Delete");
        }
    }

    //...............................Sals...........................................................

    @GetMapping("/employee/sals")
    List<EmployeeSalaryDetail> getAllSalDetails(){
        return employeeSalaryRepository.findAll();
    }

    @GetMapping("/employee/sals/{empId}")
    List<EmployeeSalaryDetail> getAllSalDetailsByEmpId(@PathVariable int empId){
        return employeeSalaryRepository.findAll().stream()
                .filter(employeeSalaryDetail -> employeeSalaryDetail.getEmployee().getId()==empId)
                .collect(Collectors.toList());
    }

    @GetMapping("/employee/sals/date/{date}")
    List<EmployeeSalaryDetail> getAllSalDetailsByDate(@PathVariable Date date){
        return employeeSalaryRepository.findAll().stream()
                .filter(employeeSalaryDetail -> employeeSalaryDetail.getDateOfPaid().equals(date))
                .collect(Collectors.toList());
    }

    @PostMapping("/employee/sals")
    EmployeeSalaryDetail SaveSalDetail(@RequestBody EmployeeSalDTO employeeSalDTO){

        String eid=employeeSalDTO.getEmployeeId();
        int n=eid.indexOf("-");
        String empId=eid.substring(0,n);

        EmployeeSalaryDetail employeeSalaryDetail= employeeSalaryRepository.save(
                EmployeeSalaryDetail.builder()
                .employee(employeeRepository.findById(Integer.valueOf(empId)).get())
                        .dateOfPaid(employeeSalDTO.getDateOfPaid())
                        .paysheetId(employeeSalDTO.getPaysheetId())
                        .salary(employeeSalDTO.getSalary())
                .build()
        );
        System.out.println(employeeSalaryDetail.getEmployee().getId());

        return employeeSalaryDetail;
    }

    @PutMapping("/employee/sals")
    EmployeeSalaryDetail updateSalDetail(@RequestBody EmployeeSalaryDetail employeeSalaryDetail){
        employeeSalaryRepository.findById(employeeSalaryDetail.getPaysheetId()).get();
        return employeeSalaryRepository.save(employeeSalaryDetail);
    }

    @DeleteMapping("/employee/sals/{id}")
    void deleteSalDetail(@PathVariable int id){

        employeeSalaryRepository.deleteById(id);
    }


}
