
package com.katumbela.paymentsystem.domain.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.katumbela.paymentsystem.domain.entities.Payment;

public interface PaymentRepository extends Repository<Payment, Long> {

    List<Payment> findByInvoiceId(Long invoiceId);

    List<Payment> findByStatus(Payment.PaymentStatus status);

    Payment save(Payment payment);
}