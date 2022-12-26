package com.sula.ranjith_learners.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TotIncomeAndExpensesDTO {

    private String grossIncome;
    private String netIncome;
    private String salariesPaid;
    private String totalOtherExpenses;

}
