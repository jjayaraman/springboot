package com.jai.springboot.controller;

import com.jai.springboot.entity.Employee;
import com.jai.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employee")
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

    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee created = employeeService.createEmployee(employee);
        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(URI.create("/api/employee" + created.getId())).body(created);
    }
}
