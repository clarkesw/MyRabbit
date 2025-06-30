package com.locsoft.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;


public class Setup {
    
    private static final String QUEUE_NAME = "tv";
    private static final String EXCHANGE_NAME = "Second-Fan";
    
    public static void main(String[] args) {
        
        String mess = "Help Me get a Job";
        ConnectionFactory cf = new ConnectionFactory();
        
        try(Connection conn = cf.newConnection();
            Channel ch = conn.createChannel()){
            
            ch.exchangeDeclare(EXCHANGE_NAME, "fanout");
            ch.queueDeclare(QUEUE_NAME, false, false, false, null);
            ch.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");
            ch.basicPublish(EXCHANGE_NAME, "", null, mess.getBytes());
            
        }catch(IOException | TimeoutException ioe){}
    }
}
