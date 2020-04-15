package com.atliuning.springcloud.controller;

import com.atliuning.springcloud.entities.CommonResult;
import com.atliuning.springcloud.entities.Payment;
import com.atliuning.springcloud.servicves.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-15 22:26
 **/
@RestController
public class OrderFeignCtr {

    @Autowired
    PaymentService paymentService;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }
}
