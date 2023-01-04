package com.sula.ranjith_learners.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "student_payments")
@Entity
public class StudentPayment implements SuperEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    private String paymentDetail;
    private Date dateOfDue;
    private Date dateOfSettled;
    private double amount;
    private double fine;


}
