package com.atliuning.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-14 23:29
 **/
@RestController
@Slf4j
public class PaymentCtr {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        System.out.println("2222");
        return "springCloud with consul:"+serverPort+"\t "+ UUID.randomUUID().toString();
    }

}
