package com.katumbela.paymentsystem.application.service;

import com.katumbela.paymentsystem.domain.entities.Invoice;
import com.katumbela.paymentsystem.domain.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import javax.mail.MessagingException; 

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service

public class BillingService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    // private emailSender emailSender;

    public Invoice createInvoice(String customerName, BigDecimal amount, LocalDate dueDate, String customerEmail)
    // throws MessagingException {
    {
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoice.setDueDate(dueDate);
        invoice.setAmount(amount);
        invoice.setStatus(Invoice.InvoiceStatus.PENDING);

        // Enviar e-mail de lembrete de fatura
        String subject = "Nova Fatura Criada";
        String body = "Olá, " + customerName + ". Sua fatura de R$" + amount + " foi criada e vence em " + dueDate;
        // emailSender.sendInvoiceReminder(customerEmail, subject, body);

        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getOverDueInvoices() {
        return invoiceRepository.findByStatus(Invoice.InvoiceStatus.OVERDUE);
    }

    public void markAsPaid(Long invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Factura Não Encontrada"));
        invoice.setStatus(Invoice.InvoiceStatus.PAID);
        invoiceRepository.save(invoice);
    }

}
