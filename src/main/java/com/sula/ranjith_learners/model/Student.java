package com.sula.ranjith_learners.model;

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
@Entity
@Table(name = "students")
public class Student implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
    @ManyToMany
    @JoinTable(
            name = "student_exam",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "exam_id")}
            )
    private List<Exam> exams;
    @ManyToMany
    @JoinTable(
            name = "student_trial",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "trial_id")}
    )
    private List<Trial> trials;
    private String isLicenseIssued;

}
