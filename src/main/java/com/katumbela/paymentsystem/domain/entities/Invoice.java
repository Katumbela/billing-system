package com.katumbela.paymentsystem.domain.entities;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;


@EntityScan
public class Invoice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @Column(nullable = false)
    private String customerName;

    public void setCustomerName(String customerName) {
        this.customerName = customerName; 
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount; 
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate; 
    }
    public void setStatus(InvoiceStatus status) {
        this.status = status; 
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public enum InvoiceStatus{
        PENDING, PAID, OVERDUE
    }

}