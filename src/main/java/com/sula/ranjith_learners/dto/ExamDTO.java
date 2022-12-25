package com.sula.ranjith_learners.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ExamDTO {


    private String id;
    private Date date;
    private Time time;
    private String venue;
}
