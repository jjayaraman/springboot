package com.jai.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceIntegrationTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void getEmployees() {
        System.out.println(employeeService.getEmployees().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void getEmployeeByIdNonExisting() {
        Long nonExistingId = 9999999999999L;
        employeeService.getEmployeeById(nonExistingId);
    }

    @Test(expected = EntityNotFoundException.class)
    public void getEmployeeByIdNull() {
        Long nonExistingId = null;
        employeeService.getEmployeeById(nonExistingId);
    }

    @Test
    public void createEmployee() {
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteEmployeeNonExisting() {
        Long nonExistingId = 9999999999999L;
        employeeService.deleteEmployee(nonExistingId);
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteEmployeeNull() {
        Long nonExistingId = null;
        employeeService.deleteEmployee(nonExistingId);
    }
}