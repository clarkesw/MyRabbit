package com.locsoft.rabbit.temp.decorator;


public abstract class Coffee {
    public abstract double getCost();
    public abstract String getDescription();
    
    @Override
    public String toString(){
        return getDescription() + "  " + getCost();
    }
}
