package com.locsoft.rabbit.temp.decorator;

import com.locsoft.rabbit.temp.decorator.addons.CaramelSyrup;
import com.locsoft.rabbit.temp.decorator.addons.Milk;


public class CoffeeClient {
    
    public static void main(String[] args) {
        Coffee myCoffee = new CaramelSyrup(new Milk(new Latte()));
        System.out.println("Result: " + myCoffee);
    }
}
