package com.locsoft.rabbit.temp.decorator;


public abstract class CoffeeDecorator extends Coffee{
    
    private Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
        System.out.println("CoffeeDecorator() ");
    }
    
    @Override
    public double getCost() {
        System.out.println("  CoffeeDecorator Cost");
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with ";
    }
}
