package com.locsoft.rabbit.temp.decorator;


public class Espresso extends Coffee{

    @Override
    public double getCost() {
        return 2.00;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    } 
}
