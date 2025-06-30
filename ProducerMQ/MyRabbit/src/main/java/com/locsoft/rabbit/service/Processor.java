package com.locsoft.rabbit.service;

import org.springframework.stereotype.Service;

@Service
public class Processor {
    
    private String data;
 
    public void processReceivedMessage(String data) {
        this.data = data;
        System.out.println("Something is processing: " + data);
        // Perform business logic here with the 'data'
        // e.g., save to database, call another API, perform calculations
    }   
    
    
    public String getData(){
        return this.data;
    }
}
