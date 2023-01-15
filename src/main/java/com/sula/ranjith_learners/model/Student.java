package com.sula.ranjith_learners.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sula.ranjith_learners.model.enums.CivilStatus;
import com.sula.ranjith_learners.model.enums.Gender;
import com.sula.ranjith_learners.model.enums.LicenceType;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "students")
public class Student implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String address;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private String contact;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;
    private Date dateOfJoined;
    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;
    @Enumerated(EnumType.STRING)
    private LicenceType licenceType;
    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    Exam exam;
    @JoinColumn(name = "trial_id", referencedColumnName = "id")
    @ManyToOne
    Trial trial;
    private String isLicenseIssued;
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Lecture> lectures;


}
