package com.sula.ranjith_learners.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentDTO {
    private  int id;
    private String name;
    private String address;
    private int age;
    private String gender;
    private String email;
    private String contact;
    private int branchId;
    private Date dateOfJoined;
    private String civilStatus;
    private String licenceType;
    private int examId;
    private int trialId;
    private String isLicenseIssued;
}
