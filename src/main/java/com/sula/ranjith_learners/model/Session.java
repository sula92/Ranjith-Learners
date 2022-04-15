package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.enums.SessionType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @Enumerated(EnumType.STRING)
    private SessionType sessionType;
    private String duration;
    private boolean isInstructorAttend;
    private int studentAttendance;

    public Session() {
    }

    public Session(long sessionId, Date date, Employee employee, SessionType sessionType, String duration, boolean isInstructorAttend, int studentAttendance) {
        this.sessionId = sessionId;
        this.date = date;
        this.employee = employee;
        this.sessionType = sessionType;
        this.duration = duration;
        this.isInstructorAttend = isInstructorAttend;
        this.studentAttendance = studentAttendance;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isInstructorAttend() {
        return isInstructorAttend;
    }

    public void setInstructorAttend(boolean instructorAttend) {
        isInstructorAttend = instructorAttend;
    }

    public int getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(int studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionId=" + sessionId +
                ", date=" + date +
                ", employee=" + employee +
                ", sessionType=" + sessionType +
                ", duration='" + duration + '\'' +
                ", isInstructorAttend=" + isInstructorAttend +
                ", studentAttendance=" + studentAttendance +
                '}';
    }
}
