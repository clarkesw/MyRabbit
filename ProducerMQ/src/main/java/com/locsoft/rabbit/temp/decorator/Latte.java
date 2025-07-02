package com.locsoft.rabbit.temp.decorator;


public class Latte extends Coffee {

    public Latte() {
        System.out.println("Latte() ");
    }

    @Override
    public double getCost() {
        System.out.println("  Latte Cost");
        return 3.50;
    }

    @Override
    public String getDescription() {
        return "Latte";
    } 
}
