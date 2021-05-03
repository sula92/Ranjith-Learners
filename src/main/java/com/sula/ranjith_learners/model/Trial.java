package com.sula.ranjith_learners.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "trials")
public class Trial implements SuperEntity {

    @Id
    private String id;
    private Date date;
    private Time time;
    private String venue;

    public Trial() {
    }

    public Trial(String id, Date date, Time time, String venue) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.venue = venue;
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

    @Override
    public String toString() {
        return "Trial{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", venue='" + venue + '\'' +
                '}';
    }
}
