package com.jai.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(schema = "employees", name = "employees")
public class Employee {

    @Id
    private Long empNo;

    private String firstName;

    private String lastName;
    private Date birthDate;
    private Date hireDate;
    private String gender;

    public Long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}


/*

    CREATE TABLE `employees` (
        `emp_no` int(11) NOT NULL,
        `birth_date` date NOT NULL,
        `first_name` varchar(14) NOT NULL,
        `last_name` varchar(16) NOT NULL,
        `gender` enum('M','F') NOT NULL,
        `hire_date` date NOT NULL,
        PRIMARY KEY (`emp_no`)
        );
        ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

*/

