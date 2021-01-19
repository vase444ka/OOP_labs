package test.gift;

import main.candy.*;
import main.candy.comparators.CaloriesComparator;
import main.candy.comparators.PriceComparator;
import main.candy.comparators.SugarComparator;
import main.candy.comparators.WeightComparator;
import main.candy.details.ChocolateSort;
import main.candy.details.Flavour;
import main.gift.CandyWrapper;
import main.gift.Material;
import main.gift.SweetGift;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SweetGiftTest {
    @Test
    public void emptyGift(){
        SweetGift gift = new SweetGift();
        Assertions.assertEquals(0, gift.getWeight());
        Assertions.assertEquals(0, gift.getPrice());
        Assertions.assertEquals(new ArrayList<>(), gift.getItems());
        Assertions.assertEquals(new ArrayList<>(), gift.findBySugarRange(0, Integer.MAX_VALUE));
    }
    @Test
    public void unwrappedGiftWithSameSweets(){
        ArrayList <CandyItem> items = new ArrayList<>();
        ArrayList <CandyItem> lowSugarItems = new ArrayList<>();
        lowSugarItems.add(new ChocolateSweets(50, 10, 20, 10, Flavour.MINT, ChocolateSort.BLACK));
        items.add(new ChocolateSweets(42, 20, 30, 43, Flavour.VANILLA, ChocolateSort.MILK));
        items.add(new ChocolateSweets(35, 25, 20, 35, Flavour.BERRY, ChocolateSort.WHITE));
        lowSugarItems.add(new ChocolateSweets(50, 10, 20, 10, Flavour.MINT, ChocolateSort.BLACK));
        items.add(new ChocolateSweets(42, 20, 30, 43, Flavour.VANILLA, ChocolateSort.MILK));
        items.addAll(lowSugarItems);

        SweetGift gift = new SweetGift(items);

        Assertions.assertEquals(50 + 42 + 35 + 50 + 42, gift.getWeight());
        Assertions.assertEquals((int)Math.ceil(10*50/100.0) +
                (int)Math.ceil(43*42/100.0) +
                (int)Math.ceil(35*35/100.0) +
                (int)Math.ceil(10*50/100.0) +
                (int)Math.ceil(43*42/100.0), gift.getPrice());
        Assertions.assertEquals(items, gift.getItems());
        Assertions.assertEquals(lowSugarItems, gift.findBySugarRange(0, 5));
    }
    @Test
    public void unwrappedGiftWithDifferentSweets(){
        ArrayList <CandyItem> items = new ArrayList<>();
        ArrayList <CandyItem> lowSugarItems = new ArrayList<>();
        lowSugarItems.add(new ChocolateSweets(50, 10, 20, 10, Flavour.MINT, ChocolateSort.BLACK));
        lowSugarItems.add(new ChocolateBar(81, 5, 300, 20, ChocolateSort.MILK, Flavour.VANILLA));
        items.add(new Cookie(35, 25, 20, 35, Flavour.BERRY));
        lowSugarItems.add(new CaramelSweets(50, 10, 20, 10, Flavour.MINT, Flavour.CHOCOLATE));
        items.add(new Waffle(100, 20, 400, 20, Flavour.VANILLA, Flavour.CHOCOLATE));
        items.addAll(lowSugarItems);

        SweetGift gift = new SweetGift(items);

        Assertions.assertEquals(50 + 81 + 35 + 50 + 100, gift.getWeight());
        Assertions.assertEquals((int)Math.ceil(10*50/100.0) + 20 +
                (int)Math.ceil(35*35/100.0) +
                (int)Math.ceil(10*50/100.0) + 20, gift.getPrice());
        Assertions.assertEquals(items, gift.getItems());
        Assertions.assertEquals(lowSugarItems, gift.findBySugarRange(0, 5));
    }
    @Test
    public void wrappedGiftWithDifferentSweets(){
        ArrayList <CandyItem> items = new ArrayList<>();
        ArrayList <CandyItem> lowSugarItems = new ArrayList<>();
        lowSugarItems.add(new ChocolateSweets(50, 10, 20, 10, Flavour.MINT, ChocolateSort.BLACK));
        lowSugarItems.add(new ChocolateBar(81, 5, 300, 20, ChocolateSort.MILK, Flavour.VANILLA));
        items.add(new Cookie(35, 25, 20, 35, Flavour.BERRY));
        lowSugarItems.add(new CaramelSweets(50, 10, 20, 10, Flavour.MINT, Flavour.CHOCOLATE));
        items.add(new Waffle(100, 20, 400, 20, Flavour.VANILLA, Flavour.CHOCOLATE));
        items.addAll(lowSugarItems);

        SweetGift gift = new SweetGift(items, new CandyWrapper(Material.WOOD, 2));

        Assertions.assertEquals(50 + 81 + 35 + 50 + 100, gift.getWeight());
        Assertions.assertEquals((int)Math.ceil(10*50/100.0) + 20 +
                (int)Math.ceil(35*35/100.0) +
                (int)Math.ceil(10*50/100.0) + 20 + gift.getWeight()*3*2, gift.getPrice());
        gift.sortItemsBy(new PriceComparator());
        List <CandyItem> giftItems = gift.getItems();
        Assertions.assertEquals(giftItems.get(0).getPrice(), 5);
        gift.sortItemsBy(new SugarComparator());
        giftItems = gift.getItems();
        Assertions.assertEquals(giftItems.get(0).getSugarWeight(), 5);
        gift.sortItemsBy(new WeightComparator());
        giftItems = gift.getItems();
        Assertions.assertEquals(giftItems.get(0).getWeight(), 35);
        gift.sortItemsBy(new CaloriesComparator());
        giftItems = gift.getItems();
        Assertions.assertEquals(giftItems.get(0).getCalories(), (int)Math.ceil(20 * 35 /100.0));
    }
}
