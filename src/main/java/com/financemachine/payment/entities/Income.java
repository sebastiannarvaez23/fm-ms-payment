package com.financemachine.payment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Income {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float basic;
    private Float additional;
    
}