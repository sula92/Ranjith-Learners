package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.enums.CivilStatus;
import com.sula.ranjith_learners.model.enums.Gender;
import com.sula.ranjith_learners.model.enums.LicenceType;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String contact;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id")
    private Branch branch;
    private Date dateOfJoined;
    @Enumerated(EnumType.STRING)
    private CivilStatus civilStatus;
    private String emergencyContactPerson;
    private String emergencyContactNumber;
    @Enumerated(EnumType.STRING)
    private LicenceType licenceType;
    @ManyToMany
    @JoinTable(
            name = "student_exam",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "exam_id")}
            )
    private List<Exam> exams;
    @ManyToMany
    @JoinTable(
            name = "student_trial",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "trial_id")}
    )
    private List<Trial> trials;

    public Student() {
    }

    public Student(long id, String name, String address, int age, Gender gender, String contact, Branch branch, Date dateOfJoined, CivilStatus civilStatus, String emergencyContactPerson, String emergencyContactNumber, LicenceType licenceType, List<Exam> exams, List<Trial> trials) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.branch = branch;
        this.dateOfJoined = dateOfJoined;
        this.civilStatus = civilStatus;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactNumber = emergencyContactNumber;
        this.licenceType = licenceType;
        this.exams = exams;
        this.trials = trials;
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

    public Date getDateOfJoined() {
        return dateOfJoined;
    }

    public void setDateOfJoined(Date dateOfJoined) {
        this.dateOfJoined = dateOfJoined;
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

    public LicenceType getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Trial> getTrials() {
        return trials;
    }

    public void setTrials(List<Trial> trials) {
        this.trials = trials;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", contact='" + contact + '\'' +
                ", branch=" + branch +
                ", dateOfJoined=" + dateOfJoined +
                ", civilStatus=" + civilStatus +
                ", emergencyContactPerson='" + emergencyContactPerson + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                ", licenceType=" + licenceType +
                ", exams=" + exams +
                ", trials=" + trials +
                '}';
    }
}
