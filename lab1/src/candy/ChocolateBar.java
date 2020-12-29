package candy;

import candy.details.*;

public class ChocolateBar extends AbstractSolidCandy{
    private ChocolateSort chocoSort;
    private Flavour topping;

    public ChocolateBar(int weight, int sugar_weight, int calories, int price, ChocolateSort choco, Flavour topping) {
        super(weight, sugar_weight, calories, price);
        this.chocoSort = choco;
        this.topping = topping;
    }
}
