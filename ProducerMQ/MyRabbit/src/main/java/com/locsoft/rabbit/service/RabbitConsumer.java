package com.locsoft.rabbit.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitConsumer {
        
    @Autowired
    Processor proc;
        
    @RabbitListener(queues = "Mobile")
    public void processOrder(String data) {
        proc.processReceivedMessage(data);
        System.out.println("Received message: " + data);
    }   
}
