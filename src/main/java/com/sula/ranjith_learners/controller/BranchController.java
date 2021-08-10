package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.BranchDTO;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Branch;
import com.sula.ranjith_learners.repository.BranchRepository;
import com.sula.ranjith_learners.service.BranchService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController//(@controller+@ResponseBody)
@RequestMapping("/api/v1/")
public class BranchController {

    @Autowired
    BranchService branchService;

    @Autowired
    BranchRepository branchRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/branches")
    public Branch saveBranch(@RequestBody @Valid  BranchDTO branchDTO) throws Exception{
        if (!(branchRepository.findAllByIdIsNotNullAndNameEquals(branchDTO.getName())==null)){
            throw new Exception("The Branch Already Exist");
        }
        Date date= branchDTO.getDateOfEstablished();

       return branchService.saveBranch(branchDTO.getId(),branchDTO.getName(),branchDTO.getAddress(), date,branchDTO.getContact());

    }

    @GetMapping("/branches")
    public List<BranchDTO> getAllBranches(){
        List<BranchDTO> branchDTOS=new ArrayList<>();
        List<Branch> branches=branchService.getAllBranches();
        branches.stream().forEach(branch -> {
            Date date= branch.getDateOfEstablished();
            branchDTOS.add(new BranchDTO(branch.getId(),branch.getName(),branch.getAddress(), date,branch.getContact()));
        });

        return branchDTOS;
    }
    
    @GetMapping("/branches/{id}")
    public Branch getBranch(@PathVariable long id) throws Exception {


        Branch branch= branchRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Such Employee"));
        //Branch branch= employeeRepository.findById(id).get();
        //Branch branch= employeeRepository.getOne(id);
        return ResponseEntity.ok(branch).getBody();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/branches/{id}")
    public Branch updateBranch(@PathVariable Long id, @RequestBody @Valid  Branch branch) throws Exception{
        Branch branch1=branchRepository.getOne(id);
        branch1.setName(branch.getName());
        branch1.setAddress(branch.getAddress());
        branch1.setDateOfEstablished(branch.getDateOfEstablished());
        branch1.setContact(branch.getContact());

        return branchRepository.save(branch1);
    }

    @DeleteMapping("/branches/{id}")
    public void deleteBranch(@PathVariable long id) throws Exception {
        if (!(branchRepository.getOne(id)==null)) {
            branchRepository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No Such Branch");
        }
    }
}
