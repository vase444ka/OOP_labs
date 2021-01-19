package main.candy;

import main.candy.details.*;

public class Waffle extends AbstractSolidCandy{
    private Flavour topping;
    private Flavour flavour;


    public Waffle(int weight, int sugarWeight, int calories, int price, Flavour topping, Flavour flavour) {
        super(weight, sugarWeight, calories, price);
        this.topping = topping;
        this.flavour = flavour;
    }
}
