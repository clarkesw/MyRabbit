package com.locsoft.rabbit;

import com.rabbitmq.client.*;
import com.rabbitmq.client.AMQP.BasicProperties; 
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RabbitProducer {

    public static void main(String[] args) throws IOException, TimeoutException, JSONException {
        
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.newConnection();
        Channel ch = conn.createChannel();
        
        sendIt(ch, "mobile", "trop", "1");
        sendIt(ch, "nope", "mob", "2");
        sendIt(ch, "tv", "trash", "3");
        
        ch.close();
        conn.close();
    }
    
    public static void sendIt(Channel ch, String val1, String val2, String count) throws IOException{
        String jObj = "Hello Dorkie!! " + count; 
        byte[] jMess = jObj.getBytes();
        
        Map<String, Object> header = new HashMap<>();
        header.put("item1", val1);
        header.put("item2", val2);
        
        BasicProperties prop = new BasicProperties().builder()
                                        .headers(header)
                                        .build();
        
        ch.basicPublish("Second-Head", "", prop, jMess);
        System.out.println("Sent C$: " + count);
    }
    
     public static void direct(Channel chDir, byte[] inB) throws IOException{
        // chDir.exchangeDeclare("mobile", "direct");
        System.out.println("inB: " + Arrays.toString(inB));
        chDir.basicPublish("Frist-Dir", "ac", null, inB);
         
     }
}

//        BasicProperties prop = new BasicProperties()
//                                        .builder()
//                                        .headers(header);
//        
//        ch.basicPublish("Second-Topic", "me.tv.ghost", prop, jMess);

//        String message = "Hello Dorkie!!";
//        byte[] byteMess = message.getBytes();
 //       direct(ch, byteMess);

//                channel.basicPublish(EXCHANGE_NAME, QUEUE_NAME,
//                                 null, // No BasicProperties object
//                                 messageBodyBytes);

//        ch.basicPublish("", "task_queue", null, "Clarkie".getBytes());
//        ch.basicPublish("", "task_queue", null, "Bella".getBytes());
//        ch.basicPublish("", "task_queue", null, "Maggie".getBytes());
//        ch.basicPublish("", "task_queue", null, "Apple".getBytes());


//        JSONObject jObj = new JSONObject();
//        
//        jObj.put("from", "01/01/25");
//        jObj.put("to", "10/09/25");
//        jObj.put("email", "clarke.job@gmail.com");
//         byte[] jMess = jObj.toString().getBytes();       