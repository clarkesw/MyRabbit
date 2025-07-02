package com.locsoft.rabbit.temp.decorator.addons;

import com.locsoft.rabbit.temp.decorator.Coffee;
import com.locsoft.rabbit.temp.decorator.CoffeeDecorator;


public class Sugar extends CoffeeDecorator {
    
    public Sugar(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + .20;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Sugar";
    }    
}
