package com.sula.ranjith_learners.model;


import com.sula.ranjith_learners.model.enums.Gender;
import com.sula.ranjith_learners.model.enums.CivilStatus;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employees")
public class Employee implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String position;
    private String contact;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;
    private double sallary;
    private Date dateOfRecruited;
    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;
    private String emergencyContactPerson;
    private String emergencyContactNumber;

    public Employee() {
    }

    public Employee(long id, String name, String address, int age, Gender gender, String position, String contact, Branch branch, double sallary, Date dateOfRecruited, CivilStatus civilStatus, String emergencyContactPerson, String emergencyContactNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.position = position;
        this.contact = contact;
        this.branch = branch;
        this.sallary = sallary;
        this.dateOfRecruited = dateOfRecruited;
        this.civilStatus = civilStatus;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactNumber = emergencyContactNumber;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public Date getDateOfRecruited() {
        return dateOfRecruited;
    }

    public void setDateOfRecruited(Date dateOfRecruited) {
        this.dateOfRecruited = dateOfRecruited;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", position='" + position + '\'' +
                ", contact='" + contact + '\'' +
                ", branch=" + branch +
                ", sallary=" + sallary +
                ", dateOfRecruited=" + dateOfRecruited +
                ", civilStatus=" + civilStatus +
                ", emergencyContactPerson='" + emergencyContactPerson + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                '}';
    }
}
