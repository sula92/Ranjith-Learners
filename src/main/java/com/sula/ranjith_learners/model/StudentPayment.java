package com.sula.ranjith_learners.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "student_payments")
@Entity
public class StudentPayment implements SuperEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    private String paymentDetail;
    private Date dateOfDue;
    private Date dateOfSettled;
    private double amount;
    private double fine;

    public StudentPayment() {
    }

    public StudentPayment(long id, Student student, String paymentDetail, Date dateOfDue, Date dateOfSettled, double amount, double fine) {
        this.id = id;
        this.student = student;
        this.paymentDetail = paymentDetail;
        this.dateOfDue = dateOfDue;
        this.dateOfSettled = dateOfSettled;
        this.amount = amount;
        this.fine = fine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(String paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public Date getDateOfDue() {
        return dateOfDue;
    }

    public void setDateOfDue(Date dateOfDue) {
        this.dateOfDue = dateOfDue;
    }

    public Date getDateOfSettled() {
        return dateOfSettled;
    }

    public void setDateOfSettled(Date dateOfSettled) {
        this.dateOfSettled = dateOfSettled;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "StudentPayment{" +
                "id=" + id +
                ", student=" + student +
                ", paymentDetail='" + paymentDetail + '\'' +
                ", dateOfDue=" + dateOfDue +
                ", dateOfSettled=" + dateOfSettled +
                ", amount=" + amount +
                ", fine=" + fine +
                '}';
    }
}
