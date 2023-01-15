package com.sula.ranjith_learners.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentPaymentDTO {

    private int Id;
    private String paymentDetail;
    private int studentId;
    private Date dateOfDue;
    private Date dateOfSettled;
    private double amount;
    private double fine;
}
