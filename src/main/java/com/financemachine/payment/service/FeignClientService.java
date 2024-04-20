package com.financemachine.payment.service;

import com.financemachine.payment.entities.Income;

public interface FeignClientService {
    
    public Income getIncome();
    
}
