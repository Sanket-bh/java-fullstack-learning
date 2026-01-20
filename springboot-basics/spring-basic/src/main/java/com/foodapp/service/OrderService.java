package com.foodapp.service;

import com.foodapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DeliveryService deliveryService;

    public void processOrder(){
        orderRepository.saveOrder();
        restaurantService.prepareFood();
        deliveryService.deliverOrder();
    }
    // TODO:
    // 1. Create method processOrder()
    // 2. Call orderRepository.saveOrder()
    // 3. Call restaurantService.prepareFood()
    // 4. Call deliveryService.deliverOrder()
}
