package com.atliuning.springcloud.service.impl;

import com.atliuning.springcloud.service.IMessageSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-18 22:04
 **/
@Slf4j
@Service
public class MessageSendImpl implements IMessageSend {

    @Autowired
    private MessageChannel output;

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("***********serial："+serial);
    }
}
