package com.locsoft.rabbit;

import org.json.JSONObject;


public class ExtractMessage {
    
    public static void getMess(String inS){
        JSONObject jj = new JSONObject(inS);
        System.out.println("From : " + jj.get("from") + " To : " + jj.get("to"));
        
    }
}
