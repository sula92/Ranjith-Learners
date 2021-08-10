package com.sula.ranjith_learners.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam implements SuperEntity {

    @Id
    private String id;
    private Date date;
    private Time time;
    private String venue;
    @ManyToMany(mappedBy = "exams")
    private List<Student> students;

    public Exam() {
    }

    public Exam(String id, Date date, Time time, String venue) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.venue = venue;
    }

    public Exam(String id, Date date, Time time, String venue, List<Student> students) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", venue='" + venue + '\'' +
                ", students=" + students +
                '}';
    }
}
