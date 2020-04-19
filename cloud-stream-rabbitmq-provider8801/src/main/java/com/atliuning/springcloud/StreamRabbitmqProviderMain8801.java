package com.atliuning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-18 22:02
 **/
@SpringBootApplication
@EnableBinding(Source.class)
public class StreamRabbitmqProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProviderMain8801.class,args);
    }
}
