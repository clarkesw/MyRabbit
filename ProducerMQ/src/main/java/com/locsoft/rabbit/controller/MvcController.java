package com.locsoft.rabbit.controller;

import com.locsoft.rabbit.beans.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit/api/v1")
public class MvcController {

    @Autowired
    private RabbitTemplate template;
    
    @GetMapping("/test/{name}")
    public String testName(@PathVariable("name")String name){
        Person p = new Person(1, name);
     //   template.convertAndSend("TV", p);
        template.convertAndSend("Second-Topic", "black.ac",p);
        template.convertAndSend("Frist-Dir", "tv",p);
        return name;
    }   
}
