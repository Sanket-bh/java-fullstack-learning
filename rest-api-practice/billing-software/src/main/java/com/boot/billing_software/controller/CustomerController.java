package com.boot.billing_software.controller;

import com.boot.billing_software.entity.Customer;
import com.boot.billing_software.entity.Product;
import com.boot.billing_software.exception.ResourceNotFoundException;
import com.boot.billing_software.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCust() {
        try{
            return new ResponseEntity<>(service.getAllCust(), HttpStatus.BAD_REQUEST);    // Get a list as response
        }catch (ResourceNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(service.addCustomer(customer),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        try{
            service.deleteById(id);
            return "Deleted Successfully";
        } catch (Exception e) {
            return "Failed to delete";
        }
    }

    @GetMapping("/{id}")
    public Customer getCustById(@PathVariable int id){
        return service.getCustById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustById(@PathVariable int id, @RequestBody Customer c){
        try{
            return ResponseEntity.ok(service.updateById(id,c));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
