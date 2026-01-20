package com.boot.billing_software.dao;

import com.boot.billing_software.entity.Customer;

import java.util.List;

public interface CustomerDaoInterface {

    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();

    Customer updateById(int id,Customer customer);

    void deleteById(int id);
}