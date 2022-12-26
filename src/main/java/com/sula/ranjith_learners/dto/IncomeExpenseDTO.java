package com.sula.ranjith_learners.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class IncomeExpenseDTO {

    private String description;
    private String Date;
    private long Amount;

}
