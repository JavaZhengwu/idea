package com.itheima.service;

import com.itheima.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    Customer findCustomerById(Integer id);

    void updateCustomer(Customer customer);

    void saveCustomer(Customer customer);
}
