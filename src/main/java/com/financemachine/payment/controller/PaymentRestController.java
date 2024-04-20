package com.financemachine.payment.controller;

import com.financemachine.payment.entities.Payment;
import com.financemachine.payment.repository.PaymentRepository;
import com.financemachine.payment.response.MonthlyBalanceResponse;
import com.financemachine.payment.service.PaymentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @GetMapping("/pending-amount")
    public MonthlyBalanceResponse getMonthlyBalance() {
        return paymentService.getMonthlyBalance();
    }
            
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(newPayment);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable long id) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            paymentRepository.deleteById(id);
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.notFound().build();
    }
}
