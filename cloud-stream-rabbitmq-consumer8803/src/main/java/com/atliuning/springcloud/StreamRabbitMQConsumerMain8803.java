package com.atliuning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-18 22:26
 **/
@SpringBootApplication
public class StreamRabbitMQConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQConsumerMain8803.class,args);
    }

}
