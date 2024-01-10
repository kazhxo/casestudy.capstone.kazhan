package com.sofy.casestudy.capstone.kazhan.service;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TextMessagingService {



    private final SimpMessagingTemplate messagingTemplate;


    public TextMessagingService(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate=messagingTemplate;
    }


    public void sendTextMessage(String content, String sender, String recipient) {


        String destination = "/topic/messages/" + recipient;
        messagingTemplate.convertAndSend(destination, createTextMessage(content, sender));
    }

    private String createTextMessage(String content, String sender){
        return sender + ": " + content;
    }
}
