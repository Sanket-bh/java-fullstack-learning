package com.boot.product.services;

import com.boot.product.exception.ProductNotFound;
import com.boot.product.model.Product;
import com.boot.product.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository repository;

    @PostConstruct
    public void loadInitialProducts() {
        repository.save(new Product(1, "Earpods", "Electronics",2000));
        repository.save(new Product(2, "Keyboard", "Electronics",6369));
    }
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product createProduct(Product product){
        try {
            return  repository.save(product);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

    }

    public Product findById(int id){
        try{
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id){
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product updateById(int id, Product product){
        try {
            return repository.updateById(id,product);

        } catch (ProductNotFound e) {
            throw (e);
        }
    }

    public List<Product> searchByName(String name){
        try{
            return repository.searchByName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
