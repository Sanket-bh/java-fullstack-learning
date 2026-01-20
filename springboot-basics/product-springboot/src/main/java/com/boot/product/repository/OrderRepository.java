package com.boot.product.repository;

import com.boot.product.exception.ProductNotFound;
import com.boot.product.model.Order;
import com.boot.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderRepository {
    private final ArrayList<Order> list=new ArrayList<>();

    public List<Order> findAll(){
        return list;
    }

    public Order findById(String id){
        return list.stream().filter(o -> o.getOrderId()==id ).findFirst().
                orElse(null);
    }

    public Order save(Order order){
        list.add(order);
        return order;
    }

    public void deleteById(String id){


//        for(int i=0;i<list.size();i++){
//            if(list.get(i).getOrderId().equalsIgnoreCase(orderid)){
//                list.remove(i);
//                break;
//            }
//        }

        //Method 2 : Collection framework (List function)
        list.removeIf(order -> order.getOrderId()==id);
    }

    public Order updateById(String id,Order order){
        Order existingOrder=findById(id);
        if(existingOrder!=null){
            existingOrder.setProductId(order.getProductId());
            existingOrder.setQty(order.getQty());
            existingOrder.setAmt(order.getAmt());
            existingOrder.setStatus(order.getStatus());
            return order;
        }else {
            throw new ProductNotFound("Order not found");
        }
    }


    
}
