package com.atliuning.springcloud.lb;

import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB {

    private static   AtomicInteger atomicInteger = new AtomicInteger(0);

    public static final int getAndIncrement(){
        int current;
        int next;
        for (;;) {
            current = atomicInteger.get();
            next = (current >= Integer.MAX_VALUE)?0:current+1;
            atomicInteger.compareAndSet(current,next);
            System.out.println(atomicInteger);
            System.out.println(atomicInteger.compareAndSet(current,next));
            System.out.println(current);
            System.out.println(next);
            System.out.println("**************");
        }
    }

    public static void main(String[] args) {
        getAndIncrement();
    }
}
