package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.enums.Result;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Table(name = "results")
@Entity
public class StudentResult {

    @Id
    private String resultSheetNo;
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

    public StudentResult() {
    }

    public StudentResult(String resultSheetNo, @NotNull Student student, Trial trials, Exam exams, Result examResult, Result trialResult) {
        this.resultSheetNo = resultSheetNo;
        this.student = student;
        this.trials = trials;
        this.exams = exams;
        this.examResult = examResult;
        this.trialResult = trialResult;
    }

    public String getResultSheetNo() {
        return resultSheetNo;
    }

    public void setResultSheetNo(String resultSheetNo) {
        this.resultSheetNo = resultSheetNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Trial getTrials() {
        return trials;
    }

    public void setTrials(Trial trials) {
        this.trials = trials;
    }

    public Exam getExams() {
        return exams;
    }

    public void setExams(Exam exams) {
        this.exams = exams;
    }

    public Result getExamResult() {
        return examResult;
    }

    public void setExamResult(Result examResult) {
        this.examResult = examResult;
    }

    public Result getTrialResult() {
        return trialResult;
    }

    public void setTrialResult(Result trialResult) {
        this.trialResult = trialResult;
    }

    @Override
    public String toString() {
        return "StudentResult{" +
                "resultSheetNo='" + resultSheetNo + '\'' +
                ", student=" + student +
                ", trials=" + trials +
                ", exams=" + exams +
                ", examResult=" + examResult +
                ", trialResult=" + trialResult +
                '}';
    }
}
