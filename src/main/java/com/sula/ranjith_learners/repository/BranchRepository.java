package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    public Branch findAllByIdIsNotNullAndNameEquals(@Param("name") String name);

}
