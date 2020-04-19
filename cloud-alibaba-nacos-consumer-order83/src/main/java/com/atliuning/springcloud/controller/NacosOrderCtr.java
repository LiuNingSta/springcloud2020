package com.atliuning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-19 13:34
 **/
@RestController
public class NacosOrderCtr {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${services-url.nacos-payment-provider}")
    private String payment_url;

    @GetMapping(value = "consumer/getPort")
    public String getServerPort(){
        return restTemplate.getForObject(payment_url + "/getPort", String.class);
    }

}
