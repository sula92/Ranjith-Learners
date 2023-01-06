package com.sula.ranjith_learners.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String lesson;
    Date date;
    Time time;
    String venue;
    String instructor;
    @ManyToMany
    @JoinTable(
            name = "student_lectures",
            joinColumns = {@JoinColumn(name = "lecture_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    //@JsonIgnore
    private List<Student> students;
}
