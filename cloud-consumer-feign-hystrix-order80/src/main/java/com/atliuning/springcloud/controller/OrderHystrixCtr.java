package com.atliuning.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atliuning.springcloud.services.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderHystrixCtr {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentHystrixService.payment_ok(id);
    }

    @HystrixCommand(fallbackMethod = "payment_timeoutHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    //timeoutInMilliseconds 配置无效  是否是Ribbon或者Feign的默认时间1s在控制 当provider端休眠>=1s 则出现服务降级
    //1.是否是Ribbon或者Feign的默认时间1s在控制     否
    //2.未知？？？？？
    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.payment_timeout(id);
    }

    public String payment_timeoutHandle(Integer id){
        return "order:80  "+Thread.currentThread().getName()+" 程序出错或请求超时！id："+id+",！！！！！！！";
    }


    @GetMapping("consumer/payment/hystrix/circuitbreaker/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fullBreak",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//出错率

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("  id 不能为负数！");
        }
        String s = IdUtil.simpleUUID();
        return "调用成功，流水号："+s;
    }
    public String paymentCircuitBreaker_fullBreak(Integer id){
        return "id 不能为负数！  "+Thread.currentThread().getName()+" 请稍后再试   id:"+id;
    }
}
