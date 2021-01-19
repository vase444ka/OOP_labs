package main.candy.comparators;

import main.candy.CandyItem;

import java.util.Comparator;

public class PriceComparator implements Comparator<CandyItem> {
    @Override
    public int compare(CandyItem o1, CandyItem o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
