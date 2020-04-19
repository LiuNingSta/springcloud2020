package com.atliuning.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-19 13:34
 **/
@RestController
public class NacosPaymentCtr {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "getPort")
    public String getServerPort(){
        return serverPort;
    }
}
