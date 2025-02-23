package com.financemachine.payment.service;

import com.financemachine.payment.repository.PaymentRepository;
import com.financemachine.payment.response.MonthlyBalanceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImp implements PaymentService {
    
    @Autowired
    PaymentRepository paymentRepository;
    
    @Autowired
    FeignClientService feignClientService;

    /*@Override
    public MonthlyBalanceResponse getMonthlyBalance() {
        Float pendinAmount = paymentRepository.getPendingAmount();
        Income income = feignClientService.getIncome();
        Float disbalance = 0.0f;
        if (pendinAmount != null) {
            disbalance = income.getBasic() + (income.getAdditional() != null ? income.getAdditional() : 0) - pendinAmount;
        }
        MonthlyBalanceResponse response = new MonthlyBalanceResponse(pendinAmount, disbalance);
        return response;
    }*/
    
}