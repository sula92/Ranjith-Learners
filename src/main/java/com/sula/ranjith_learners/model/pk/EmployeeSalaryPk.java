package com.sula.ranjith_learners.model.pk;


import com.sula.ranjith_learners.model.Employee;
import com.sula.ranjith_learners.model.SuperEntity;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class EmployeeSalaryPk implements SuperEntity {

    @Column(name = "employee_id")
    private long employee_id;
    @Column(name = "date_of_paid")
    @Temporal(TemporalType.DATE)
    private Date date;

    public EmployeeSalaryPk() {
    }

    public EmployeeSalaryPk(long employee_id, Date date) {
        this.employee_id = employee_id;
        this.date = date;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EmployeeSalaryPk{" +
                "employee_id=" + employee_id +
                ", date=" + date +
                '}';
    }
}
