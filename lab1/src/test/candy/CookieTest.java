package test.candy;

import main.candy.CandyItem;
import main.candy.Cookie;
import main.candy.details.Flavour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CookieTest {
    @Test
    public void cookieTest(){
        CandyItem cookie = new Cookie(35, 25, 20, 35, Flavour.BERRY);
        Assertions.assertEquals((int)Math.ceil(35*20/100.0), cookie.getCalories());
        Assertions.assertEquals((int)Math.ceil(35*35/100.0), cookie.getPrice());
        Assertions.assertEquals(35, cookie.getWeight());
        Assertions.assertEquals((int)Math.ceil(35*25/100.0), cookie.getSugarWeight());
    }
}
