package com.locsoft.rabbit.controller;

import com.locsoft.rabbit.beans.Person;
import com.rabbitmq.client.*;
import java.io.*;
import java.util.concurrent.TimeoutException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MvcController {

    @Autowired
    private RabbitTemplate template;
    
    private static final String HEADER_EXCHANGE_NAME = "Second-Head";
    
    @GetMapping("/test/{name}/{key}")
    public String testName(@PathVariable("name")String name, @PathVariable("key")String key){
        Person p = new Person(1, name);
        
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutput out = new ObjectOutputStream(bos)){
            out.writeObject(p);
            out.flush();
            out.close();

            byte[] byteMess = bos.toByteArray();
            bos.close();

            Message builder = MessageBuilder.withBody(byteMess)
                            .setHeader("item1", "mobile")
                            .setHeader("item2", "what")
                            .build();
            
            Message builder2 = MessageBuilder.withBody(byteMess)
                .setHeader("item1", "tv")
                .build();
            
//            template.send(HEADER_EXCHANGE_NAME, "",builder);
//            template.send(HEADER_EXCHANGE_NAME, "",builder2);
//            template.convertAndSend("AC", name + 2);       
            template.convertAndSend("", key, name + 1);
            
            System.out.println("Sent message: " + HEADER_EXCHANGE_NAME);
        }catch(IOException ioe){
            System.err.println(ioe);
        }
        return name;
    }   
    
    @GetMapping("/test/{name}/key/{key}")
    public String testChannel(@PathVariable("name")String name, @PathVariable("key")String key) throws IOException, TimeoutException{
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.newConnection();
        Channel ch = conn.createChannel();
        
        ch.basicPublish("First-Fan", key, null, name.getBytes());
        return name + " key: " + key;
    }   
}
