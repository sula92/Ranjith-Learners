package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.OtherExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OtherExpenseRepository extends JpaRepository<OtherExpense, Integer> {

    @Query(value = "SELECT SUM(amount) FROM other_expenses WHERE date LIKE '2023-01%'", nativeQuery = true)
    Long getTotOtherExpenses();
}
