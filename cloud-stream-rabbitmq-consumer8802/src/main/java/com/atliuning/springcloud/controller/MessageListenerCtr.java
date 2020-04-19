package com.atliuning.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-18 22:32
 **/
@EnableBinding(Sink.class)
public class MessageListenerCtr {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<?> message) {
        System.out.println(message.getPayload());
    }
}
