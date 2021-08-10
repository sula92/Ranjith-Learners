package com.sula.ranjith_learners.dto;


import java.time.Instant;
import java.util.Date;

public class BranchDTO {
    private long id;
    private String name;
    private String address;
    private Date dateOfEstablished;
    private String contact;

    public BranchDTO() {
    }

    public BranchDTO(long id, String name, String address, Date dateOfEstablished, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfEstablished = dateOfEstablished;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfEstablished() {
        return dateOfEstablished;
    }

    public void setDateOfEstablished(Date dateOfEstablished) {
        this.dateOfEstablished = dateOfEstablished;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "BranchDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfEstablished=" + dateOfEstablished +
                ", contact='" + contact + '\'' +
                '}';
    }
}
