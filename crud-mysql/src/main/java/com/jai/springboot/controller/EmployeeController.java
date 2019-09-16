package com.jai.springboot.controller;

import com.jai.springboot.entity.Employee;
import com.jai.springboot.repository.EmployeeRepository;
import com.jai.springboot.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(path = "/test")
    public String test() {
        return "working...";
    }
//
//    @GetMapping(path = "/employees")
//    public List<Employee> getEmployees() {
//        Instant start = Instant.now();
//        List<Employee> employees = employeeService.getEmployees();
//        Instant end = Instant.now();
//        System.out.println("controller /all took : " + Duration.between(start, end).toMillis() + " ms");
//        return employees;
//    }

    @GetMapping(path = "/employees")
    public Page<Employee> getEmployeesPageable(Pageable pageable) {
        Instant start = Instant.now();
        Page<Employee> employees = employeeRepository.findAll(pageable);
        Instant end = Instant.now();
        logger.debug("pageable : " + pageable);
        logger.info("controller /employees took : " + Duration.between(start, end).toMillis() + " ms");
        return employees;
    }

//    @GetMapping(path = "/stream/all")
//    public Stream<Employee> streamAllEmployees() {
//        Instant start = Instant.now();
//        List<Employee> employees = employeeService.getEmployees();
//        Instant end = Instant.now();
//        logger.info("controller /all took : " + Duration.between(start, end).toMillis() + " ms");
//        return employees;
//    }

    @GetMapping(path = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Long id) {
        Instant start = Instant.now();

        Employee employee = employeeService.getEmployeeById(id);

        Instant end = Instant.now();
        logger.info("controller /{id} took : " + Duration.between(start, end).toMillis() + " ms");
        return employee;
    }

    //    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        logger.debug("employee : " + employee);
        Employee created = employeeService.createEmployee(employee);
        if (created == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(URI.create("/api/employee" + created.getId())).body(created);
    }

    @PutMapping(path = "/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            Employee updated = employeeService.updateEmployee(employee);
            return ResponseEntity.ok().body(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
