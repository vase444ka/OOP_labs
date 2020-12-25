package candy;

import candy.details.*;

public class Cookie extends AbstractWeighedCandy{
    private Flavour topping;

    public Cookie(int weight, int sugar, int ccal, int price, Flavour topping){
        this.topping = topping;
        super.init(weight, sugar, ccal, price);
    }
}
