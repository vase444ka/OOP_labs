package candy;

import candy.details.ChocolateSort;
import candy.details.Flavour;

public class ChocolateSweets extends AbstractSweets{
    private ChocolateSort chocolateSort;

    public ChocolateSweets(int weight, int sugar, int ccal, int price, Flavour topping, ChocolateSort chocolateSort){
        super(weight, sugar, ccal, price, topping);
        this.chocolateSort = chocolateSort;
    }
}
