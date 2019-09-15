package com.jai.springboot.service;

import com.jai.springboot.entity.Employee;
import com.jai.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "employees")
    public List<Employee> getEmployees() {
        Instant start = Instant.now();
        List<Employee> employees = employeeRepository.findAll();
        Instant end = Instant.now();
        System.out.println("" + Duration.between(start, end).toMillis() + " milliseconds");
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = null;

        Instant start = Instant.now();
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new EntityNotFoundException("Employee not found");
        }
        Instant end = Instant.now();
        System.out.println("getEmployeeById took : " + Duration.between(start, end).toMillis() + " milliseconds.");
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Long currentMaxEmpId = employeeRepository.findEmployeeIdMax();
        employee.setId(currentMaxEmpId + 1);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        if (employee.getId() == null) {
            throw new EntityNotFoundException("Entity not found.");
        } else {
            Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
            if (!optionalEmployee.isPresent()) {
                throw new EntityNotFoundException("Entity not found.");
            } else {
                return employeeRepository.save(employee);
            }
        }
    }
}
