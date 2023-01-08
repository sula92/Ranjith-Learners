package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {

    @Query(value = "SELECT SUM(amount) FROM income WHERE date LIKE '2023-01%'", nativeQuery = true)
    Long getTotIncome();
}
