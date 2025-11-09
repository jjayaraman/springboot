package com.jai.springboot.graphql.service;

import com.jai.springboot.graphql.model.CreateCustomerInput;
import com.jai.springboot.graphql.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    List<Customer> customers = Arrays.asList(
            new Customer(1, "Jay", 10002000),
            new Customer(2, "Tom", 20002000),
            new Customer(3, "Mike", 30002000)
    );

    public List<Customer> getCustomers() {
        return customers;
    }

    public Optional<Customer> getCustomerById(int id) {
        return customers.stream().filter(c -> c.id() == id).findFirst();
    }

    public Customer create(CreateCustomerInput input) {
        Customer customer = new Customer(input.id(), input.name(), input.accountNumber());
        customers.add(customer);
        return customer;
    }
}
