package com.sula.ranjith_learners.model;

import javax.persistence.*;

@Entity
@Table(name = "Student_Profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exam;
    @OneToOne
    @JoinColumn(name = "trial_id", referencedColumnName = "id")
    private Trial trial;
    @OneToOne
    @JoinColumn(name = "resultSheetNo", referencedColumnName = "resultSheetNo")
    private StudentResult studentResult;
    @OneToOne
    @JoinColumn(name = "payment_no", referencedColumnName = "id")
    private StudentPayment studentPayment;

    public StudentProfile() {
    }

    public StudentProfile(int profileId, Student student, Exam exam, Trial trial, StudentResult studentResult, StudentPayment studentPayment) {
        this.profileId = profileId;
        this.student = student;
        this.exam = exam;
        this.trial = trial;
        this.studentResult = studentResult;
        this.studentPayment = studentPayment;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Trial getTrial() {
        return trial;
    }

    public void setTrial(Trial trial) {
        this.trial = trial;
    }

    public StudentResult getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(StudentResult studentResult) {
        this.studentResult = studentResult;
    }

    public StudentPayment getStudentPayment() {
        return studentPayment;
    }

    public void setStudentPayment(StudentPayment studentPayment) {
        this.studentPayment = studentPayment;
    }

    @Override
    public String toString() {
        return "StudentProfile{" +
                "profileId=" + profileId +
                ", student=" + student +
                ", exam=" + exam +
                ", trial=" + trial +
                ", studentResult=" + studentResult +
                ", studentPayment=" + studentPayment +
                '}';
    }
}
