package com.jai.springboot.aws.entity.repository;

import com.jai.springboot.aws.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetEmployees() {
        System.out.println(employeeRepository.findAll());
    }

    @Test
    public void testCreate() {

        List<Employee> employees = new ArrayList<Employee>();

        Employee employee1 = new Employee("jay", "jay", "jay@gmail.com", new Date());
        Employee employee2 = new Employee("jay", "jay", "jay@gmail.com", new Date());
        Employee employee3 = new Employee("jay", "jay", "jay@gmail.com", new Date());
        Employee employee4 = new Employee("jay", "jay", "jay@gmail.com", new Date());
        Employee employee5 = new Employee("jay", "jay", "jay@gmail.com", new Date());
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        employeeRepository.saveAll(employees);

    }
}