package com.boot.billing_software.controller;
import com.boot.billing_software.dto.InvoiceRequestDTO;
import com.boot.billing_software.dto.InvoiceResponseDTO;
import com.boot.billing_software.entity.Invoice;
import com.boot.billing_software.exception.InsufficientStockException;
import com.boot.billing_software.exception.ResourceNotFoundException;
import com.boot.billing_software.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // POST /invoices
    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody InvoiceRequestDTO request) {
        try{
            return ResponseEntity.ok(invoiceService.generateInvoice(request));
        } catch (InsufficientStockException e) {
            throw e;
        }
    }

    // GET /invoices
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        try{
            return ResponseEntity.ok(invoiceService.getAllInvoices());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /invoices/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable String id) {
        try{
            return ResponseEntity.ok(invoiceService.getInvoiceById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /invoices/customer/{customerId}
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Invoice>> getByCustomer(@PathVariable int customerId) {
        try{
            return ResponseEntity.ok(invoiceService.getInvoicesByCustomerId(customerId));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
