package com.boot.billing_software.services;

import com.boot.billing_software.dto.InvoiceRequestDTO;
import com.boot.billing_software.dto.InvoiceResponseDTO;
import com.boot.billing_software.entity.Invoice;
import com.boot.billing_software.entity.InvoiceItem;
import com.boot.billing_software.entity.Product;
import com.boot.billing_software.exception.InsufficientStockException;
import com.boot.billing_software.exception.ResourceNotFoundException;
import com.boot.billing_software.repository.CustomerRepository;
import com.boot.billing_software.repository.InvoiceRepository;
import com.boot.billing_software.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public InvoiceResponseDTO generateInvoice(InvoiceRequestDTO dto) {

        // ✔ Customer must exist
        if (customerRepository.findCustById(dto.getCustomerId()) == null) {
            throw new ResourceNotFoundException("Customer not found");
        }

        Invoice invoice = new Invoice();
        invoice.setCustomerId(dto.getCustomerId());

        double subTotal = 0;
        double totalTax = 0;

        List<InvoiceItem> items = new ArrayList<>();

        for (InvoiceRequestDTO.ProductQuantity pq : dto.getProducts()) {

            Product product = productRepository.findById(pq.getProductId());
            if (product == null) {
                throw new ResourceNotFoundException("Product not found");
            }


            if (product.getStockQuantity() < pq.getQuantity()) {
                throw new InsufficientStockException(
                        "Insufficient stock for product: " + product.getName()
                );
            }


            double price = product.getPrice() * pq.getQuantity();
            double tax = price * product.getGstPercentage() / 100;

            InvoiceItem item = new InvoiceItem();
            item.setProductId(product.getId());
            item.setQuantity(pq.getQuantity());
            item.setPrice(price);
            item.setTaxAmount(tax);
            item.setTotal(price + tax);

            subTotal += price;
            totalTax += tax;

            product.setStockQuantity(
                    product.getStockQuantity() - pq.getQuantity()
            );
            productRepository.updateById(product.getId(), product);

            items.add(item);
        }

        invoice.setItems(items);
        invoice.setTotalAmount(subTotal);
        invoice.setTotalTax(totalTax);
        invoice.setDiscount(dto.getDiscount());
        invoice.setFinalAmount(subTotal + totalTax - dto.getDiscount());

        invoiceRepository.save(invoice);

        InvoiceResponseDTO response = new InvoiceResponseDTO();
        response.setInvoiceId(invoice.getInvoiceId());
        response.setInvoiceDate(invoice.getInvoiceDate());
        response.setCustomerId(invoice.getCustomerId());
        response.setTotalAmount(invoice.getTotalAmount());
        response.setTotalTax(invoice.getTotalTax());
        response.setDiscount(invoice.getDiscount());
        response.setFinalAmount(invoice.getFinalAmount());

        return response;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(String id) {
        Invoice invoice = invoiceRepository.findById(id);
        if (invoice == null) {
            throw new ResourceNotFoundException("Invoice not found");
        }
        return invoice;
    }

    public List<Invoice> getInvoicesByCustomerId(int customerId) {
        return invoiceRepository.findByCustomerId(customerId);
    }
}
