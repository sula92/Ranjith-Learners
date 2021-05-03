package com.sula.ranjith_learners.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehicles")
public class Vehicle implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private String brancdAndModel;
    @OneToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    @NotNull
    private Branch branch;
    private String owner;
    private String ownersContact;
    private String ownersAddress;

    public Vehicle() {
    }

    public Vehicle(long id, String number, String brancdAndModel, Branch branch, String owner, String ownersContact, String ownersAddress) {
        this.id = id;
        this.number = number;
        this.brancdAndModel = brancdAndModel;
        this.branch = branch;
        this.owner = owner;
        this.ownersContact = ownersContact;
        this.ownersAddress = ownersAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrancdAndModel() {
        return brancdAndModel;
    }

    public void setBrancdAndModel(String brancdAndModel) {
        this.brancdAndModel = brancdAndModel;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnersContact() {
        return ownersContact;
    }

    public void setOwnersContact(String ownersContact) {
        this.ownersContact = ownersContact;
    }

    public String getOwnersAddress() {
        return ownersAddress;
    }

    public void setOwnersAddress(String ownersAddress) {
        this.ownersAddress = ownersAddress;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", brancdAndModel='" + brancdAndModel + '\'' +
                ", branch=" + branch +
                ", owner='" + owner + '\'' +
                ", ownersContact='" + ownersContact + '\'' +
                ", ownersAddress='" + ownersAddress + '\'' +
                '}';
    }
}
