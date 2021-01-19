package test.candy;

import main.candy.CandyItem;
import main.candy.Waffle;
import main.candy.details.Flavour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WaffleTest {
    @Test
    public void waffleTest(){
        CandyItem waffle = new Waffle(100, 20, 400, 20, Flavour.VANILLA, Flavour.CHOCOLATE);
        Assertions.assertEquals(400, waffle.getCalories());
        Assertions.assertEquals(20, waffle.getPrice());
        Assertions.assertEquals(100, waffle.getWeight());
        Assertions.assertEquals(20, waffle.getSugarWeight());
    }
}
