package test.gift;

import main.gift.CandyWrapper;
import main.gift.Material;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CandyWrapperTest {
    @Test
    public void EmptyWrapperTest(){
        CandyWrapper wrapper = new CandyWrapper();
        Assertions.assertEquals(0, wrapper.countPrice(Integer.MAX_VALUE));
    }
    @Test
    public void WoodWrapperTest(){
        Material material = Material.WOOD;
        CandyWrapper wrapper = new CandyWrapper(material, 2);
        Assertions.assertEquals(material.getCostPerGram()*2*10, wrapper.countPrice(10));
        Assertions.assertEquals(material.getCostPerGram()*2*3, wrapper.countPrice(3));
        wrapper = new CandyWrapper(material, 1.3);
        Assertions.assertEquals((int)Math.ceil(material.getCostPerGram()*1.3*10), wrapper.countPrice(10));
        Assertions.assertEquals((int)Math.ceil(material.getCostPerGram()*1.3*5), wrapper.countPrice(5));
    }
    @Test
    public void PolymerWrapperTest(){
        Material material = Material.POLYMER;
        CandyWrapper wrapper = new CandyWrapper(material, 1.45);
        Assertions.assertEquals((int)Math.ceil(material.getCostPerGram()*1.45*10), wrapper.countPrice(10));
        Assertions.assertEquals((int)Math.ceil(material.getCostPerGram()*1.45*5), wrapper.countPrice(5));
    }
}
