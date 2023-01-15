package com.sula.ranjith_learners.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "Employee_Salary_Details")
public class EmployeeSalaryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int paysheetId;

    Date dateOfPaid;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    private long salary;


}
