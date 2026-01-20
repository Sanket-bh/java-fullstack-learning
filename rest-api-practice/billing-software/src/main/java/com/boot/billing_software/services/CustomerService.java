package com.boot.billing_software.services;

import com.boot.billing_software.dao.CustomerDao;
import com.boot.billing_software.entity.Customer;
import com.boot.billing_software.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService( CustomerDao customerDao) {
        this.customerDao = customerDao;

    }

    public Customer addCustomer(Customer customer){
        try{
            return customerDao.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer findCustById(int id){
        try {
            return customerDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer updateById(int id,Customer customer){
        try{
            return customerDao.updateById(id, customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCust(){
        return customerDao.findAll();
    }

    public Customer getCustById(int id){
        try{
            return customerDao.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id){
        try{
            customerDao.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
