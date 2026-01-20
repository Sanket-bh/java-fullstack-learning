package com.boot.billing_software.controller;

import com.boot.billing_software.entity.Product;
import com.boot.billing_software.exception.ResourceNotFoundException;
import com.boot.billing_software.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        try{
            return new ResponseEntity<>(service.getProductList(), HttpStatus.BAD_REQUEST);    // Get a list as response
        }catch (ResourceNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.addProduct(product),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return service.getById(id);
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

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateById(@PathVariable int id, @RequestBody Product p){
        try{
            return ResponseEntity.ok(service.updateById(id,p));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
