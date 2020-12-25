package candy;

import candy.details.*;

public class ChocolateBar extends AbstractSolidCandy{
    private ChocolateSort chocoSort;
    private Flavour topping;

    public ChocolateBar(int weight, int sugar_weight, int calories, int price, ChocolateSort choco, Flavour topping) {
        this.chocoSort = choco;
        this.topping = topping;
        init(weight, sugar_weight, calories, price);
    }
}
