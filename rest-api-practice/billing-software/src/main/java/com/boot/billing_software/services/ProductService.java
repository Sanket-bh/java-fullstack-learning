package com.boot.billing_software.services;

import com.boot.billing_software.entity.Product;
import com.boot.billing_software.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product addProduct(Product product){
        try{
            return repository.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product updateById(int id,Product product){
        try{
            return repository.updateById(id,product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getProductList(){
        return repository.findAll();
    }

    public Product getById(int id){
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


}
