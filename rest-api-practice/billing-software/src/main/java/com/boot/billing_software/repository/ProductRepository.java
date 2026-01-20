package com.boot.billing_software.repository;

import com.boot.billing_software.entity.Product;
import com.boot.billing_software.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final ArrayList<Product> list = new ArrayList<>();

    public Product findById(int id) {
        return list.stream().filter(p -> p.getId() == id).findFirst().
                orElse(null);
    }

    public Product save(Product product) {
        list.add(product);
        return product;
    }

    public Product updateById(int id, Product product) {
        Product existingProduct = findById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStockQuantity(product.getStockQuantity());
            existingProduct.setPrice(product.getPrice());

            return product;
        } else {
            throw new ResourceNotFoundException("Resource not found");
        }
    }

    public List<Product> findAll() {
        return list;
    }

    public void deleteById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                break;
            }
        }
    }
}
