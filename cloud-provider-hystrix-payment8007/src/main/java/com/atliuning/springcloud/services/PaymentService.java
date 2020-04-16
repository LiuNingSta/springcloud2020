package com.atliuning.springcloud.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    public String payment_Ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+" payment_Ok,id:"+id+",O(∩_∩)O";
    }

    /*@HystrixCommand(fallbackMethod = "payment_timeoutHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    public String payment_timeout(Integer id) {
        int time_out = 1000;
        try {
            TimeUnit.MILLISECONDS.sleep(time_out);
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" payment_timeout,id:"+id+",耗时(秒)："+time_out;
    }

    /*public String payment_timeoutHandle(Integer id){
        return "线程池："+Thread.currentThread().getName()+" payment_timeout,id:"+id+",/(ㄒoㄒ)/~~";
    }*/

}
