package com.boot.product.controller;

import com.boot.product.model.Order;
import com.boot.product.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        try{
            return ResponseEntity.ok(service.createOrder(order));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrder(){
        try{
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Order> getByid(@PathVariable String id){
        try{
            return ResponseEntity.ok(service.getOrderById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
