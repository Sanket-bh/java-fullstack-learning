package com.boot.billing_software.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Invoice {

    private String invoiceId;
    private LocalDate invoiceDate;
    private int customerId;
    private double totalAmount;
    private double totalTax;
    private double discount;
    private double finalAmount;
    private List<InvoiceItem> items;

    public Invoice() {
        this.invoiceId = UUID.randomUUID().toString();
        this.invoiceDate = LocalDate.now();
    }

    public Invoice(List<InvoiceItem> items) {
        this();
        this.items = items;
    }

    public Invoice(int invoiceId, LocalDate invoiceDate, int customerId,
                   double totalAmount, double totalTax,
                   double discount, double finalAmount) {
        this.invoiceId = UUID.randomUUID().toString();
        this.invoiceDate = invoiceDate;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.totalTax = totalTax;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }



    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }


}
