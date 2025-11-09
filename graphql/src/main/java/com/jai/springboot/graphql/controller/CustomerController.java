package com.jai.springboot.graphql.controller;


import com.jai.springboot.graphql.model.CreateCustomerInput;
import com.jai.springboot.graphql.model.Customer;
import com.jai.springboot.graphql.service.CustomerService;
import graphql.GraphQLException;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
    public List<Customer> customers() {
        return customerService.getCustomers();
    }

    @QueryMapping
    public Customer customerById(@Argument Integer id) {
        return customerService.getCustomerById(id).orElseThrow(() -> new GraphQLException("No records found for the given id: " + id));
    }


    @MutationMapping
    public Customer createCustomer(@Argument CreateCustomerInput input) {
        return customerService.create(input);
    }

}
