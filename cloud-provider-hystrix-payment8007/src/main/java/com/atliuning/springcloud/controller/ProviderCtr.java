package com.atliuning.springcloud.controller;

import com.atliuning.springcloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProviderCtr {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentService.payment_Ok(id);
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return paymentService.payment_timeout(id);
    }
}
