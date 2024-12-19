package com.katumbela.paymentsystem.infra.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.katumbela.paymentsystem.application.service.BillingService;
import com.katumbela.paymentsystem.domain.entities.Invoice;

@RestController
@RequestMapping("/api/billing")

public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/create")
    public ResponseEntity<Invoice> createInvoice(
            @RequestParam String customerName,
            @RequestParam BigDecimal amount,
            @RequestParam String dueDate,
            @RequestParam String customerEmail) {

        Invoice invoice = billingService.createInvoice(customerName, amount, LocalDate.parse(dueDate), customerEmail);

        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<Invoice>> getOverDueInvoices() {
        List<Invoice> overDueInvoice = billingService.getOverDueInvoices();

        return ResponseEntity.ok(overDueInvoice);
    }
}