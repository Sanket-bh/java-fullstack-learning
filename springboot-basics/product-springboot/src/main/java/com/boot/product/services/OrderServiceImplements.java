package com.boot.product.services;

import com.boot.product.model.Order;
import com.boot.product.repository.OrderRepository;
import com.boot.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImplements implements OrderService{
    private final OrderRepository repository;

    public OrderServiceImplements(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order createOrder(Order order) {
        Order newOrder= new Order(order.getProductId(), order.getQty(), order.getAmt(),order.getStatus());
        repository.save(newOrder);
        return newOrder;
    }

    @Override
    public Order getOrderById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public Order updateOrder(String id, Order order) {
        return repository.updateById(id,order);
    }

//    @Override
//    public Order cancelOrder(Order order) {
//        return null;
//    }


}
