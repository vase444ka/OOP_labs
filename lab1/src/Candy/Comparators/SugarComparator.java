package Candy.Comparators;

import Candy.CandyItem;

import java.util.Comparator;

public class SugarComparator implements Comparator<CandyItem> {
    @Override
    public int compare(CandyItem o1, CandyItem o2) {
        return o1.getSugarWeight() - o2.getSugarWeight();
    }
}

