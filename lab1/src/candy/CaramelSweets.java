package candy;

import candy.details.Flavour;

public class CaramelSweets extends AbstractSweets {
    private Flavour caramelFlavour;

    public CaramelSweets(int weight, int sugar, int ccal, int price, Flavour topping, Flavour caramel){
        caramelFlavour = caramel;
        super.init(weight, sugar, ccal, price, topping);
    }
}