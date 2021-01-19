package test.candy;

import main.candy.CandyItem;
import main.candy.CaramelSweets;
import main.candy.details.Flavour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaramelSweetsTest {
    @Test
    public void caramelSweetsTest(){
        CandyItem caramel = new CaramelSweets(50, 10, 20, 10, Flavour.MINT, Flavour.CHOCOLATE);
        Assertions.assertEquals((int)Math.ceil(20*50/100.0), caramel.getCalories());
        Assertions.assertEquals((int)Math.ceil(50*10/100.0), caramel.getPrice());
        Assertions.assertEquals(50, caramel.getWeight());
        Assertions.assertEquals((int)Math.ceil(50*10/100.0), caramel.getSugarWeight());
    }
}
