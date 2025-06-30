package com.locsoft.rabbit.controller;

import com.locsoft.rabbit.beans.Person;
import com.locsoft.rabbit.service.Processor;
import com.locsoft.rabbit.service.RabbitConsumer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitController {
 
    @Autowired
    private RabbitTemplate template;
    
    @Autowired
    RabbitConsumer rabbitService;
    
    @Autowired
    Processor proc;
    
//    @Autowired
//    private Queue queue;
        
    @GetMapping("/test/{id}/{name}")
    public String testMe( @PathVariable("name")String name){
        
        String message = "Hello " + name + "! ";
        
        //this.template.convertAndSend("TV", message);
        this.template.convertAndSend("Second-Fan", "", message);
        System.out.println(" [x] Sent: " + message);
        return message;
    }
 
    @GetMapping("/test2/{id}/{name}")
    public Person testMe2(@PathVariable("id")int id, @PathVariable("name")String name) throws IOException{
        Person p = new Person(id, name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(p);
        oos.flush();
        oos.close();
        
        byte[] byteMess = baos.toByteArray();
        baos.close();
        
        Message mess = MessageBuilder.withBody(byteMess)
                .setHeader("item1", "tv")
                .setHeader("item2", "mob")
                .build();

        template.send("Second-Head", "", mess);
        System.out.println(" [x] Sent: " + p);
        return p;
    }
    
    @GetMapping("/test")
    public String testMe(){   
        return proc.getData();
    }
}
