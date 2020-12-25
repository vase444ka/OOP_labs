package Candy;

import Candy.Details.*;

public class ChocolateBar extends AbstractSolidCandy{
    private ChocolateSort _choco_sort;
    private Flavour _topping;

    public ChocolateBar(int weight, int sugar_weight, int calories, int price) {
        super(weight, sugar_weight, calories, price);
    }

    /*public ChocolateBar(int weight, int sugar_weight, int calories, int price, ChocolateSort choco, Flavour topping) {
        _choco_sort = choco;
        _topping = topping;
        super(weight, sugar_weight, calories, price);
    }*/
}
