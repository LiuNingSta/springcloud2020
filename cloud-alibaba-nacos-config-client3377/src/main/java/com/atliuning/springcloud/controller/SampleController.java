package com.atliuning.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-19 22:21
 **/
@RestController
@RefreshScope
public class SampleController {

    @Value("${config.username}")
    String username;
    @Value("${config.aaa}")
    String aaa;


    @GetMapping("nacos/config/get")
    public String getConfig(){
        return username+"----------"+aaa;
    }
}
