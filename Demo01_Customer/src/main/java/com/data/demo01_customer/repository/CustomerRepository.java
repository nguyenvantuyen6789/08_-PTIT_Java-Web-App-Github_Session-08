package com.data.demo01_customer.repository;

import com.data.demo01_customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);

    boolean save(Customer customer);
}
