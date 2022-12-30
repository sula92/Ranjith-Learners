package com.sula.ranjith_learners.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BranchDTO {
    private int id;
    private String name;
    private String address;
    private String email;
    private Date dateOfEstablished;
    private String contact;


}
