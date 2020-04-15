package com.atliuning.springcloud.servicves;

import com.atliuning.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-15 22:25
 **/
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

}
