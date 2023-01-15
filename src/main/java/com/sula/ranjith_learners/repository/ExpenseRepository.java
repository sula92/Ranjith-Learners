package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository  extends JpaRepository<Expense, Integer> {

    @Query(value = "SELECT SUM(amount) FROM expense", nativeQuery = true)
    Long getTotOtherExpenses();
}
