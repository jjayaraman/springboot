package com.jai.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "employees", name = "employees")
public class Employee {



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

