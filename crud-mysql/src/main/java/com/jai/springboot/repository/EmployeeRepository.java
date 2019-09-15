package com.jai.springboot.repository;

import com.jai.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select max(emp_no) from employees", nativeQuery = true)
    Long findEmployeeIdMax();

}
