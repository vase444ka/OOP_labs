package Candy;

import Candy.Details.*;

public class Waffle extends AbstractSolidCandy{
    private Flavour _topping;
    private Flavour _flavour;


    public Waffle(int weight, int sugar_weight, int calories, int price) {
        super(weight, sugar_weight, calories, price);
    }
}
