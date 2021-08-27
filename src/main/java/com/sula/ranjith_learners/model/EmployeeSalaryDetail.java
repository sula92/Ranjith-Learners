package com.sula.ranjith_learners.model;

import com.sula.ranjith_learners.model.pk.EmployeeSalaryPk;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee_Salary_Details")
public class EmployeeSalaryDetail {

    @EmbeddedId
    EmployeeSalaryPk employeeSalaryPk;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Employee employee;
    private long salary;

    public EmployeeSalaryDetail() {
    }

    public EmployeeSalaryDetail(EmployeeSalaryPk employeeSalaryPk, Employee employee, long salary) {
        this.employeeSalaryPk = employeeSalaryPk;
        this.employee = employee;
        this.salary = salary;
    }

    public EmployeeSalaryDetail(long employee_id,Date date, Employee employee, long salary) {
        this.employeeSalaryPk = new EmployeeSalaryPk(employee_id,date);
        this.employee = employee;
        this.salary = salary;
    }

    public EmployeeSalaryPk getEmployeeSalaryPk() {
        return employeeSalaryPk;
    }

    public void setEmployeeSalaryPk(EmployeeSalaryPk employeeSalaryPk) {
        this.employeeSalaryPk = employeeSalaryPk;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeSalaryDetail{" +
                "employeeSalaryPk=" + employeeSalaryPk +
                ", employee=" + employee +
                ", salary=" + salary +
                '}';
    }
}
