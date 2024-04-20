package com.financemachine.payment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyBalanceResponse {
    
    private float pendingAmount;
    private float disbalance;
    
}
