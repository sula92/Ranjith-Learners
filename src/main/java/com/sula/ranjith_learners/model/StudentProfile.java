package com.sula.ranjith_learners.model;

import javax.persistence.*;

@Entity
@Table(name = "Student_Profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int profileId;

    /*@OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "exam_id", referencedColumnName = "id")
    private Exam exam;
    @OneToOne
    @JoinColumn(name = "trial_id", referencedColumnName = "id")
    private Trial trial;*/

    @OneToOne
    @JoinColumn(name = "resultSheetNo", referencedColumnName = "resultSheetNo")
    private StudentResult studentResult;
    @OneToOne
    @JoinColumn(name = "payment_no", referencedColumnName = "id")
    private StudentPayment studentPayment;

    public StudentProfile() {
    }

    public StudentProfile(int profileId, StudentResult studentResult, StudentPayment studentPayment) {
        this.profileId = profileId;
        this.studentResult = studentResult;
        this.studentPayment = studentPayment;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
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
                ", studentResult=" + studentResult +
                ", studentPayment=" + studentPayment +
                '}';
    }
}
