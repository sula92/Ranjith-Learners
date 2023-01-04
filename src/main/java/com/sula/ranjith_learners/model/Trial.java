package com.sula.ranjith_learners.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trials")
public class Trial implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date date;
    private Time time;
    private String venue;


}
