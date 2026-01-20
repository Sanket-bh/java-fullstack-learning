package com.boot.billing_software.dto;

import java.util.List;

public class InvoiceRequestDTO {

    private int customerId;
    private List<ProductQuantity> products;
    private double discount;

    // getters and setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<ProductQuantity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductQuantity> products) {
        this.products = products;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // 🔹 Inner class because no separate DTO is allowed
    public static class ProductQuantity {
        private int productId;
        private int quantity;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
