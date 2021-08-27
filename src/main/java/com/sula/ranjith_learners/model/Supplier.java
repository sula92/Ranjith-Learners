package com.sula.ranjith_learners.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String contact;
    private String email;
    @OneToMany(mappedBy = "supplier")
    private List<Vehicle> vehicles;

    public Supplier() {
    }

    public Supplier(long supplierId, String name, String address, String contact, String email, List<Vehicle> vehicles) {
        this.id = supplierId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.vehicles = vehicles;
    }

    public long getSupplierId() {
        return id;
    }

    public void setSupplierId(long supplierId) {
        this.id = supplierId;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
