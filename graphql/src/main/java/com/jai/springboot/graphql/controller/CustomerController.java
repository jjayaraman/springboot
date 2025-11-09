package com.jai.springboot.graphql.controller;


import com.jai.springboot.graphql.model.Customer;
import com.jai.springboot.graphql.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerService.getCustomers();
    }

    @QueryMapping
    public Customer customerById(@Argument int id) {
        return customerService.getCustomerById(id).orElseThrow();
    }

}
