package candy;

import candy.details.*;

public abstract class AbstractSweets extends AbstractWeighedCandy{
    private Flavour topping;

    public AbstractSweets(int weight, int sugar, int ccal, int price, Flavour topping){
        super(weight, sugar, ccal, price);
        this.topping = topping;
    }
}
