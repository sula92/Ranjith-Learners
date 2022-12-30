package com.sula.ranjith_learners.service;

import com.sula.ranjith_learners.model.Branch;
import com.sula.ranjith_learners.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    public Branch saveBranch(int id, String name, String address, String email, Date dateOfEstablished, String contact){
        Branch branch=branchRepository.save(new Branch(id,name,address,email,dateOfEstablished,contact));
        return branch;
    }

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    /*public void deleteBranch(){
        branchRepository.delete(Branch b);
    }*/
}
