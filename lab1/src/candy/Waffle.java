package candy;

import candy.details.*;

public class Waffle extends AbstractSolidCandy{
    private Flavour topping;
    private Flavour flavour;


    public Waffle(int weight, int sugar_weight, int calories, int price, Flavour topping, Flavour flavour) {
        super(weight, sugar_weight, calories, price);
        this.topping = topping;
        this.flavour = flavour;
    }
}
