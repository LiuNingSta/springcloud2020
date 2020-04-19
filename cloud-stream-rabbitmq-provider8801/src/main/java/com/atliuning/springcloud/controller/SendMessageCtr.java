package com.atliuning.springcloud.controller;

import com.atliuning.springcloud.service.IMessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: L.N
 * @create: 2020-04-18 22:21
 **/
@RestController
public class SendMessageCtr {

    @Autowired
    private IMessageSend iMessageSend;

    @GetMapping(value = "send")
    public void send(){
        iMessageSend.send();
    }

}
