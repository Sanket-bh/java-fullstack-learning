package com.boot.product.controller;

import com.boot.product.exception.ProductNotFound;
import com.boot.product.model.Product;
import com.boot.product.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// rest api used for communication of different application over internet
// via HTTP methods(GET,POST,Delete,PUT,etc)
// It is an architectural style , not a protocol
// Resources-> any data or object (Product as a JSON object)
// URIs -> Uniform Resource Identifiers (used for unique identity)
// Statelessness -> Each requets from a client to the server must contain
// all the information necessary to understand and process it.

// Representation -> JSON, XML,HTML

// How APIs Works -> 1. Client sends the request
//                   2. Server process the request
//                   3. Server sends the response
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;   // ✅ final is best practice

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET http://localhost:8080/products
    @GetMapping
    public ResponseEntity <List<Product>> getAll() {
        try{
            return new ResponseEntity<>(service.getAllProducts(),HttpStatus.BAD_REQUEST);    // Get a list as response
        }catch (ProductNotFound e){
            return ResponseEntity.badRequest().build();
        }
    }

    // GET http://localhost:8080/products/search?name=earpods
    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        // for now returning all, later you can filter by name
        return service.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.createProduct(product),HttpStatus.CREATED);

        }



    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return service.findById(id);
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
        } catch (ProductNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/{name}")
    public List<Product> getByName(@PathVariable String name){
        try{
            return service.searchByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/filter")
//    public List<Product> filterProduct(@RequestParam int min,@RequestParam int max){
//
//    }
}




