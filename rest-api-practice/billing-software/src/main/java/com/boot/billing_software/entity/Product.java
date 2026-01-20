package com.boot.billing_software.entity;

public class Product {
    private int id;
    private String name;
    private double price;
    private double gstPercentage;
    private int stockQuantity;

    public Product(int id, String name, double price, double gstPercentage, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.gstPercentage = gstPercentage;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getGstPercentage() {
        return gstPercentage;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGstPercentage(double gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
