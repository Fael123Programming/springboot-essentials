package com.rafael.springboot.repository;

import com.rafael.springboot.domain.customer.Customer;

import java.util.List;

/**
 * This class will manage the connection with database.
 */

public interface CustomerRepository {
    List<Customer> listAll();
}
