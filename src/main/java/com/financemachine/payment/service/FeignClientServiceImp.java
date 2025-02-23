package com.financemachine.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FeignClientServiceImp implements FeignClientService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    /*public Income getIncome() {
        String url = "http://localhost:8002/income";
        String jsonResponse = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        Income income = gson.fromJson(jsonResponse, Income.class);
        return income;
    }*/
    
}
