package com.atliuning.springcloud.lb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB {

    private static   AtomicInteger atomicInteger = new AtomicInteger(0);

    @Autowired
    private DiscoveryClient discoveryClient;

    public static final int getAndIncrement(){
        int current;
        int next;
        for (;;) {
            current = atomicInteger.get();
            next = (current >= Integer.MAX_VALUE)?0:current+1;
            if(atomicInteger.compareAndSet(current,next)){
                System.out.println("****第几次访问："+next);
                return next;
            }
        }
    }

    public URI BalanceLoad(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if(instances != null && instances.size() > 0){
            int index = getAndIncrement() % instances.size();
            ServiceInstance serviceInstance = instances.get(index);
            return serviceInstance.getUri();
        }
        return null;
    }
}
