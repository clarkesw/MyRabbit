package com.locsoft.rabbit.temp.decorator.addons;

import com.locsoft.rabbit.temp.decorator.Coffee;
import com.locsoft.rabbit.temp.decorator.CoffeeDecorator;


public class CaramelSyrup extends CoffeeDecorator {
    
    public CaramelSyrup(Coffee decoratedCoffee) {
        super(decoratedCoffee);
        System.out.println("CaramelSyrup() ");
    }
    
    @Override
    public double getCost() {
        System.out.println("  CaramelSyrup Cost");
        return super.getCost() + .75;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Caramel Syrup";
    }      
}
