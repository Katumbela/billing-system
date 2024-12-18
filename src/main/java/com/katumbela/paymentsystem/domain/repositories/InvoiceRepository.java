package com.katumbela.paymentsystem.domain.repositories;

import com.katumbela.paymentsystem.domain.entities.Invoice;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends Repository<Invoice, Long> {

    List<Invoice> findByStatus(Invoice.InvoiceStatus status);

    Optional<Invoice> findById(Long id);

    Invoice save(Invoice invoice);

}
