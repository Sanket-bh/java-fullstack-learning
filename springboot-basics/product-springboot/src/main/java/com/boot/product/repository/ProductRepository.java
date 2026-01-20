package com.boot.product.repository;

import com.boot.product.exception.ProductNotFound;
import com.boot.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final ArrayList<Product> list=new ArrayList<>();

    public List<Product> findAll(){
        return list;
    }

    public Product findById(int id){
        return list.stream().filter(p -> p.getId()==id ).findFirst().
                orElse(null);
    }

    public Product save(Product product){
        list.add(product);
        return product;
    }

    public void deleteById(int id){


        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                list.remove(i);
                break;
            }
        }

        //Method 2 : Collection framework (List function)
//        list.removeIf(product -> product.getId()==id);
    }

    public Product updateById(int id,Product product){
        Product existingProduct=findById(id);
        if(existingProduct!=null){
            existingProduct.setName(product.getName());
            existingProduct.setType(product.getType());
            existingProduct.setPrice(product.getPrice());
            return product;
        }else {
            throw new ProductNotFound("Product not found");
        }
    }

    public List<Product> searchByName(String name) {
        return list.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name)).toList();
    }



}
