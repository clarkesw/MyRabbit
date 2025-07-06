package com.locsoft.rabbit;

import com.rabbitmq.client.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;


public class RabbitConsumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.newConnection();
        Channel ch = conn.createChannel();
                
        DeliverCallback call = (tag, delivery) -> {
            String str = new String(delivery.getBody(), StandardCharsets.UTF_8);
            //  ExtractMessage.getMess(str);
            System.out.println("String Len: " + str.length());
            System.out.println("String: " + str);
            ch.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        
        ch.basicConsume("tv", false, call, tag -> {});
        System.out.println("Latch: ");
        
    }
}
