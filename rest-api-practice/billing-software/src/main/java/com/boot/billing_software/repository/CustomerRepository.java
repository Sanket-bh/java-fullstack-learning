package com.boot.billing_software.repository;

import com.boot.billing_software.entity.Customer;
import com.boot.billing_software.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Customer findCustById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().
                orElse(null);
    }

    public Customer updateById(int id, Customer customer) {
        Customer existingCustomer = findCustById(id);
        if (existingCustomer != null) {
            existingCustomer.setName(customer.getName());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setAddress(customer.getAddress());
            return customer;
        } else {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public List<Customer> getAllCust() {

        return customers;
    }

    public Customer getCustById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().
                orElse(null);
    }


    public void deleteById(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                customers.remove(i);
                break;
            }
        }
    }
}
