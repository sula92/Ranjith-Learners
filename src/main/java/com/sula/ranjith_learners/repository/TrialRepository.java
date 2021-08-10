package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Trial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrialRepository extends JpaRepository<Trial,Long> {

    Optional<Trial> findTopByOrderByIdDesc();
}
