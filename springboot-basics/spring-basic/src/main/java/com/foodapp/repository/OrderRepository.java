package com.foodapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public void saveOrder(){
        System.out.println("Order saved in repository");
    }

    // TODO:
    // 1. Create method saveOrder()
    // 2. Print "Order saved in repository"
}
