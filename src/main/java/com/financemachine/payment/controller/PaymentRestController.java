package com.financemachine.payment.controller;

import com.financemachine.payment.entities.Payment;
import com.financemachine.payment.repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {
    
    @Autowired
    PaymentRepository paymentRepository;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<Payment> findALL() {
        return paymentRepository.findAll();
    }
}
