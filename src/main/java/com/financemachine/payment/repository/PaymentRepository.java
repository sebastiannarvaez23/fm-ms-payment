package com.financemachine.payment.repository;

import com.financemachine.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    
    @Query("SELECT SUM(p.payment) FROM Payment p WHERE paid = false")
    public Float getPendingAmount();
    
}