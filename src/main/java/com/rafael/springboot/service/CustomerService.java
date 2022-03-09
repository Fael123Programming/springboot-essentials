package com.rafael.springboot.service;

import com.rafael.springboot.domain.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * All business logic comes in service classes.
 */
@Service
public class CustomerService {
//    private final CustomerRepository customerRepository;
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>(List.of(new Customer("Jorge Mayer", 1L),
                new Customer("Marianna Pitcher", 2L), new Customer("Rafael Fonseca", 3L)));
    }

    public List<Customer> listAll() {
        return customers;
    }

    public Customer findById(long id) {
        return customers.stream().
                filter(customer -> customer.getId() == id).
                findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer with id " + id + " does not exist"));
                //Bad request is depicted by the code 400.
    }

    public Customer save(Customer customer) {
        customer.setId(ThreadLocalRandom.current().nextLong(4, 1000000));
        customers.add(customer);
        return customer;
    }

    public void delete(long id) {
        customers.remove(findById(id));
    }
}
