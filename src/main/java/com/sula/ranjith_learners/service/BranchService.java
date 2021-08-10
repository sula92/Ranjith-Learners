package com.sula.ranjith_learners.service;

import com.sula.ranjith_learners.model.Branch;
import com.sula.ranjith_learners.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    public Branch saveBranch(long id, String name, String address, Date dateOfEstablished, String contact){
        Branch branch=branchRepository.save(new Branch(id,name,address,dateOfEstablished,contact));
        return branch;
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    /*public void deleteBranch(){
        branchRepository.delete(Branch b);
    }*/
}
