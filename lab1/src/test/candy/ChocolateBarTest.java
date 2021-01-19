package test.candy;

import main.candy.CandyItem;
import main.candy.ChocolateBar;
import main.candy.details.ChocolateSort;
import main.candy.details.Flavour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChocolateBarTest {
    @Test
    public void WaffleTest(){
        CandyItem chocolate = new ChocolateBar(81, 5, 300, 20, ChocolateSort.MILK, Flavour.VANILLA);
        Assertions.assertEquals(300, chocolate.getCalories());
        Assertions.assertEquals(20, chocolate.getPrice());
        Assertions.assertEquals(81, chocolate.getWeight());
        Assertions.assertEquals(5, chocolate.getSugarWeight());
    }
}
