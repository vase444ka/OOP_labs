package main.candy;

import main.candy.details.*;

public class ChocolateBar extends AbstractSolidCandy{
    private ChocolateSort chocoSort;
    private Flavour topping;

    public ChocolateBar(int weight, int sugarWeight, int calories, int price, ChocolateSort choco, Flavour topping) {
        super(weight, sugarWeight, calories, price);
        this.chocoSort = choco;
        this.topping = topping;
    }
}
