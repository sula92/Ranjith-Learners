package com.sula.ranjith_learners.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSalDTO {

    int paysheetId;

    Date dateOfPaid;

    String employeeId;
    long salary;
}
