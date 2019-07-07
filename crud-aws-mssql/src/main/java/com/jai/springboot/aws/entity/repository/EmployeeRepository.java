package com.jai.springboot.aws.entity.repository;


import com.jai.springboot.aws.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Long, Employee> {

}
