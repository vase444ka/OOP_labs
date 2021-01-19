package main.candy;

import main.candy.details.*;

public class Cookie extends AbstractWeighedCandy{
    private Flavour topping;

    public Cookie(int weight, int sugar, int ccal, int price, Flavour topping){
        super(weight, sugar, ccal, price);
        this.topping = topping;
    }
}
