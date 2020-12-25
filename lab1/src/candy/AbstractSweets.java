package candy;

import candy.details.*;

public abstract class AbstractSweets extends AbstractWeighedCandy{
    private Flavour topping;

    protected void init(int weight, int sugar, int ccal, int price, Flavour topping){
        this.topping = topping;
        super.init(weight, sugar, ccal, price);
    }
}
