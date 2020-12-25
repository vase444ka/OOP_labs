package candy.comparators;

import candy.CandyItem;

import java.util.Comparator;

public class CaloriesComparator implements Comparator<CandyItem> {
    @Override
    public int compare(CandyItem o1, CandyItem o2) {
        return o1.getCalories() - o2.getCalories();
    }
}

