package com.boot.product.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private String orderId;
    private int productId;
    private int qty;
    private int amt;
    private String status;

    public Order( int productId, int qty, int amt, String status) {
        this.orderId = UUID.randomUUID().toString();
        this.productId = productId;
        this.qty = qty;
        this.amt = amt;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQty() {
        return qty;
    }

    public int getAmt() {
        return amt;
    }

    public String getStatus() {
        return status;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
