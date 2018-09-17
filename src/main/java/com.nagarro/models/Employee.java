package com.nagarro.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Sanyam Goel created on 16/9/18
 */
@Entity
@Table(name = "employee_details")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "employee_code", nullable = false, unique = true)
    private long employeeCode;

    @Column(name = "employee_name", nullable = false, length = 500)
    private String employeeName;

    @Column(name = "location")
    private String location;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "dob")
    private String dateOfBirth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeCode=" + employeeCode +
                ", employeeName='" + employeeName + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
