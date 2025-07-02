package com.locsoft.rabbit.service;

import com.locsoft.rabbit.beans.Person;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


//@Service
public class RabbitConsumer {
        
//    @Autowired
//    Processor proc;
//        
//    @RabbitListener(queues = "TV")
    public void processOrder(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInput inO = new ObjectInputStream(bis);
        Person p = (Person)inO.readObject();
        
        inO.close();
        bis.close();
        
        System.out.println("Received message: " + p);
    }   
    
//    @RabbitListener(queues = "Mobile")
//    public void processOrder(String data) {
//        proc.processReceivedMessage(data);
//        System.out.println("Received message: " + data);
//    }   
}
