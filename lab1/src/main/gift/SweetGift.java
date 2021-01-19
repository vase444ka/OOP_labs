package main.gift;

import main.candy.CandyItem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class SweetGift{
    private List <CandyItem> items;
    private CandyWrapper wrapping;

    public SweetGift(){
        items = new ArrayList<>();
        wrapping = new CandyWrapper();
    }

    public SweetGift(List <CandyItem> items){
        this.items = items;
        wrapping = new CandyWrapper();
    }

    public SweetGift(List <CandyItem> items, CandyWrapper wrapping){
        this.items = items;
        this.wrapping = wrapping;
    }

    public void addItem(CandyItem ci){
        items.add(ci);
    }

    public int getWeight(){
        int totalWeight = 0;
        for (var it: items){
            totalWeight += it.getWeight();
        }
        return totalWeight;
    }

    public int getPrice(){
        int totalPrice = 0;
        for (var it: items){
            totalPrice += it.getPrice();
        }
        totalPrice += wrapping.countPrice(this.getWeight());
        return totalPrice;
    }

    //the search is naive because items list is always sorted by different keys
    public List <CandyItem> findBySugarRange(int minSugar, int maxSugar) throws IllegalArgumentException{
        if (minSugar > maxSugar || minSugar < 0)
            throw new IllegalArgumentException();

        var acceptableCandy = new LinkedList <CandyItem>();
        int total_weight = 0;
        for (var it: items){
            if (it.getSugarWeight() >= minSugar && it.getSugarWeight() <= maxSugar)
                acceptableCandy.add(it);
        }
        return acceptableCandy;
    }

    public void sortItemsBy(Comparator<CandyItem> sortCmp){
        items.sort(sortCmp);
    }

    public List<CandyItem> getItems(){return items;}
}
