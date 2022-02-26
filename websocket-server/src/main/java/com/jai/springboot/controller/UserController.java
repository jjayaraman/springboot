package com.jai.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private SimpMessagingTemplate template;

    // Receive /greeting from a client
    // Send the received greeting to all subscribed users /topic/greetings
    @MessageMapping(value = "/hello")
    @SendTo(value = "/topic/greetings")
    public String hello(@Payload String payload) {
//        template.convertAndSend(payload);
        System.out.println("xxxxx ss:: " +payload);
        return payload;
    }
}
