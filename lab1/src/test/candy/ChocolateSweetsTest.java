package test.candy;

import main.candy.CandyItem;
import main.candy.ChocolateSweets;
import main.candy.details.ChocolateSort;
import main.candy.details.Flavour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChocolateSweetsTest {
    @Test
    public void CaramelSweetsTest(){
        CandyItem chocolateSweets = new ChocolateSweets(50, 10, 20, 10, Flavour.MINT, ChocolateSort.BLACK);
        Assertions.assertEquals((int)Math.ceil(50*20/100.0), chocolateSweets.getCalories());
        Assertions.assertEquals((int)Math.ceil(50*10/100.0), chocolateSweets.getPrice());
        Assertions.assertEquals(50, chocolateSweets.getWeight());
        Assertions.assertEquals((int)Math.ceil(50*10/100.0), chocolateSweets.getSugarWeight());
    }
}
