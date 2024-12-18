package com.katumbela.paymentsystem.application.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katumbela.paymentsystem.domain.entities.Invoice;
import com.katumbela.paymentsystem.domain.entities.Payment;
import com.katumbela.paymentsystem.domain.entities.Payment.PaymentStatus;
import com.katumbela.paymentsystem.domain.repositories.InvoiceRepository;
import com.katumbela.paymentsystem.domain.repositories.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    public Payment createPayment(Long invoiceId, double amount) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Factura não encontrada"));

        if (invoice.getStatus() == Invoice.InvoiceStatus.PAID) {
            throw new RuntimeException("Esta Factura já foi paga");
        }

        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setInvoice(invoice);
        payment.setStatus(PaymentStatus.PAID);
        payment.setPaymentDate(LocalDate.now());

        return paymentRepository.save(payment);
    }
}
