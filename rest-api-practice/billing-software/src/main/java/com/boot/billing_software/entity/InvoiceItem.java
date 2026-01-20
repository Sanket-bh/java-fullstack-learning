package com.boot.billing_software.entity;

import java.util.UUID;

public class InvoiceItem {

    private String id;
    private int productId;
    private int quantity;
    private double price;
    private double taxAmount;
    private double total;


    public InvoiceItem() {
        this.id = UUID.randomUUID().toString();
    }

    public InvoiceItem(String id, int productId, int quantity,
                       double price, double taxAmount, double total) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.taxAmount = taxAmount;
        this.total = total;
    }


    public String getId() {
        return id;
    }

    public int getproductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getTotal() {
        return total;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
