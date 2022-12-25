package com.sula.ranjith_learners.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Rent_Payment")
public class RentPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;
    @Column(name = "date_of_paid")
    private Date dateOfPaid;
    private String note;

    public RentPayment() {
    }

    public RentPayment(int paymentId, Vehicle vehicle, Date dateOfPaid, String note) {
        this.paymentId = paymentId;
        this.vehicle = vehicle;
        this.dateOfPaid = dateOfPaid;
        this.note = note;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDateOfPaid() {
        return dateOfPaid;
    }

    public void setDateOfPaid(Date dateOfPaid) {
        this.dateOfPaid = dateOfPaid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "RentPayment{" +
                "paymentId=" + paymentId +
                ", vehicle=" + vehicle +
                ", dateOfPaid=" + dateOfPaid +
                ", note='" + note + '\'' +
                '}';
    }
}
