package com.financemachine.payment.controller;

import com.financemachine.payment.entities.Payment;
import com.financemachine.payment.repository.PaymentRepository;
import com.financemachine.payment.service.PaymentService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/payment")
public class PaymentRestController {
    
    @Autowired
    PaymentRepository paymentRepository;
    
    @Autowired
    PaymentService paymentService;
    
    @GetMapping()
    public List<Payment> findALL() {
        return paymentRepository.findAll();
    }

    /* @GetMapping("/pending-amount")
    public MonthlyBalanceResponse getMonthlyBalance() {
        return paymentService.getMonthlyBalance();
    }*/

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(newPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable UUID id, @RequestBody Payment paymentDetails) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setDescription(paymentDetails.getDescription());
                    payment.setPayment(paymentDetails.getPayment());
                    payment.setPayday(paymentDetails.getPayday());
                    payment.setPaymentlink(paymentDetails.getPaymentlink());
                    payment.setPaid(paymentDetails.isPaid());
                    Payment updatedPayment = paymentRepository.save(payment);
                    return ResponseEntity.ok(updatedPayment);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable UUID id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            paymentRepository.deleteById(id);
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.notFound().build();
    }
}
