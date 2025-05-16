package com.data.demo01_customer.service;

import com.data.demo01_customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    List<Customer> search(String fullName, String email);

    boolean save(Customer customer);
    boolean delete(int id);

}
