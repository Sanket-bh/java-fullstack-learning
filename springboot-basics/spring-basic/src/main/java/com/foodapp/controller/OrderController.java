package com.foodapp.controller;

import com.foodapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    public void placeOrder(){
        System.out.println("Order placed successfully");
        orderService.processOrder();
    }

    // TODO:
    // 1. Create method placeOrder()
    // 2. Print "Order placed successfully"
    // 3. Call orderService.processOrder()
}
