package com.sula.ranjith_learners.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String address;
    private String email;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateOfEstablished;
    private String contact;


}
