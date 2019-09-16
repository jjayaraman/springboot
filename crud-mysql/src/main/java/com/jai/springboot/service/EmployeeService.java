package com.jai.springboot.service;

import com.jai.springboot.entity.Employee;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface EmployeeService {
    @Cacheable(value = "employees")
    List<Employee> getEmployees();

    Employee getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}
