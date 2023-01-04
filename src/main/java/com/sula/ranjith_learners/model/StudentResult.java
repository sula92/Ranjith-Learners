package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.enums.Result;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "results")
@Entity
public class StudentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int resultSheetNo;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "trial_id", referencedColumnName = "id")
    private Trial trials;
    @ManyToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exams;
    @Enumerated(EnumType.STRING)
    private Result examResult;
    @Enumerated(EnumType.STRING)
    private Result trialResult;


}
