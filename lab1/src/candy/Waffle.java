package candy;

import candy.details.*;

public class Waffle extends AbstractSolidCandy{
    private Flavour topping;
    private Flavour flavour;


    public Waffle(int weight, int sugar_weight, int calories, int price, Flavour topping, Flavour flavour) {
        this.topping = topping;
        this.flavour = flavour;
        init(weight, sugar_weight, calories, price);
    }
}
