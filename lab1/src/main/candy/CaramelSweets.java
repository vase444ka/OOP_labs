package main.candy;

import main.candy.details.Flavour;

public class CaramelSweets extends AbstractSweets {
    private Flavour caramelFlavour;

    public CaramelSweets(int weight, int sugarWeight, int ccal, int price, Flavour topping, Flavour caramelFlavour){
        super(weight, sugarWeight, ccal, price, topping);
        this.caramelFlavour = caramelFlavour;
    }
}
