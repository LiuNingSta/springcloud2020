package com.atliuning.springcloud.controller;

import com.atliuning.springcloud.entities.CommonResult;
import com.atliuning.springcloud.entities.Payment;
import com.atliuning.springcloud.lb.MyLB;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@Api(tags = "共有接口")
public class OrderCtr {

    private static final String PAYMENT_URL="http://CLOUD-PROVIDER-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MyLB myLB;

    @GetMapping("/consumer/payment/create")
    @ApiOperation("新增付款")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    @ApiOperation("查询付款")
    @ApiImplicitParam(name = "id",value = "ID",required = true,paramType = "path",dataType = "Long")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    @ApiOperation("查询付款")
    public String lb(){
        URI uri = myLB.BalanceLoad();
        if(uri == null) return null;
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
