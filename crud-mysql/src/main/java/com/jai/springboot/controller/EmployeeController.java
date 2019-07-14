package com.jai.springboot.controller;

import com.jai.springboot.entity.Employee;
import com.jai.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/test")
    public String test() {
        return "working...";
    }

    @GetMapping(path = "/all")
    public List<Employee> getEmployees() {
        Instant start = Instant.now();
        List<Employee> employees = employeeService.getEmployees();
        Instant end = Instant.now();
        System.out.println("controller /all took : " + Duration.between(start, end).toMillis() + " ms");
        return employees;
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Long id) {
        Instant start = Instant.now();

        Employee employee = employeeService.getEmployeeById(id);

        Instant end = Instant.now();
        System.out.println("controller /{id} took : " + Duration.between(start, end).toMillis() + " ms");
        return employee;

    }
}
