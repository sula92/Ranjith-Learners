package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.BranchDTO;
import com.sula.ranjith_learners.dto.BranchStudentCountDTO;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Branch;
import com.sula.ranjith_learners.model.Student;
import com.sula.ranjith_learners.repository.BranchRepository;
import com.sula.ranjith_learners.repository.StudentRepository;
import com.sula.ranjith_learners.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
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
public class BranchController {

    @Autowired
    BranchService branchService;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    StudentRepository studentRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/branches")
    public Branch saveBranch(@RequestBody @Valid  BranchDTO branchDTO) throws Exception{
        if (!(branchRepository.findAllByIdIsNotNullAndNameEquals(branchDTO.getName())==null)){
            throw new Exception("The Branch Already Exist");
        }
        Date date= branchDTO.getDateOfEstablished();

       return branchService.saveBranch(branchDTO.getId(),branchDTO.getName(),branchDTO.getAddress(), branchDTO.getEmail(), date,branchDTO.getContact());

    }

    @GetMapping("/branches")
    public List<BranchDTO> getAllBranches(){
        List<BranchDTO> branchDTOS=new ArrayList<>();
        List<Branch> branches=branchService.getAllBranches();
        branches.stream().forEach(branch -> {
            Date date= branch.getDateOfEstablished();
            branchDTOS.add(new BranchDTO(branch.getId(),branch.getName(),branch.getAddress(), branch.getEmail(), date,branch.getContact()));
        });

        return branchDTOS;
    }

    @GetMapping("/branches/counts")
    public BranchStudentCountDTO getAllBranchStudentCounts(){
        int gam=0;
        int yakkala=0;
        int hiri=0;

        List<Student> studentList=studentRepository.findAll();

        for (int i = 0; i <studentList.size() ; i++) {
            if (studentList.get(i).getBranch().getName().equalsIgnoreCase("gampaha")){
                gam++;
            }
            else if (studentList.get(i).getBranch().getName().equalsIgnoreCase("yakkala")){
                yakkala++;
            }
            else {
                hiri++;
            }
        }

        return BranchStudentCountDTO.builder().gampaha(gam).yakkala(yakkala).hiripitiya(hiri).build();


    }
    
    @GetMapping("/branches/{id}")
    public Branch getBranch(@PathVariable int id) throws Exception {


        Branch branch= branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such Branch"));
        //Branch branch= employeeRepository.findById(id).get();
        //Branch branch= employeeRepository.getOne(id);
        return ResponseEntity.ok(branch).getBody();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/branches/{id}")
    public Branch updateBranch(@PathVariable int id, @RequestBody @Valid  Branch branch) throws Exception{
        Branch branch1=branchRepository.getOne(id);
        branch1.setName(branch.getName());
        branch1.setAddress(branch.getAddress());
        branch1.setDateOfEstablished(branch.getDateOfEstablished());
        branch1.setContact(branch.getContact());
        branch1.setEmail(branch.getEmail());

        return branchRepository.save(branch1);
    }

    @DeleteMapping("/branches/{id}")
    public void deleteBranch(@PathVariable int id) throws Exception {
        if (!(branchRepository.getOne(id)==null)) {
            branchRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
