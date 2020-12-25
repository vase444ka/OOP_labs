package candy.comparators;

import candy.CandyItem;

import java.util.Comparator;

public class WeightComparator implements Comparator<CandyItem> {
    @Override
    public int compare(CandyItem o1, CandyItem o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
