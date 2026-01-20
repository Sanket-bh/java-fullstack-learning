package com.boot.billing_software.repository;

import com.boot.billing_software.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final List<Invoice> invoices = new ArrayList<>();

    public Invoice save(Invoice invoice) {
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice findById(String id) {
        return invoices.stream()
                .filter(i -> i.getInvoiceId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Invoice> findByCustomerId(int customerId) {
        return invoices.stream()
                .filter(i -> i.getCustomerId() == customerId)
                .toList();
    }
}
