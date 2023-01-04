package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.enums.SessionType;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @Enumerated(EnumType.STRING)
    private SessionType sessionType;
    private String duration;
    private boolean isInstructorAttend;
    private int studentAttendance;


}
