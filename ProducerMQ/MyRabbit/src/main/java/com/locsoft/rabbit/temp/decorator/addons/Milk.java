package com.locsoft.rabbit.temp.decorator.addons;

import com.locsoft.rabbit.temp.decorator.Coffee;
import com.locsoft.rabbit.temp.decorator.CoffeeDecorator;


public class Milk extends CoffeeDecorator{
    
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
        System.out.println("Milk() ");
    }
    
    @Override
    public double getCost() {
        System.out.println("  Milk Cost");
        return super.getCost() + .50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Milk";
    }
}
