package gift;

import candy.CandyItem;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class SweetGift{
    private List <CandyItem> _items;
    private CandyWrapper _wrapping;

    public SweetGift(){
        _items = new ArrayList<>();
        _wrapping = new CandyWrapper();
    }

    public SweetGift(List <CandyItem> items){
        _items = items;
        _wrapping = new CandyWrapper();
    }

    public SweetGift(List <CandyItem> items, CandyWrapper wrapping){
        _items = items;
        _wrapping = wrapping;
    }

    public void addItem(CandyItem ci){
        _items.add(ci);
    }

    public int getWeight(){
        int total_weight = 0;
        for (var it: _items){
            total_weight += it.getWeight();
        }
        return total_weight;
    }

    public int getPrice(){
        int total_price = 0;
        for (var it: _items){
            total_price += it.getPrice();
        }
        total_price += _wrapping.countPrice(this.getWeight());
        return total_price;
    }

    //the search is naive because items list is always sorted by different keys
    public List <CandyItem> findBySugarRange(int min_sugar, int max_sugar) throws IllegalArgumentException{
        if (min_sugar > max_sugar || min_sugar < 0)
            throw new IllegalArgumentException();

        var acceptable_candy = new LinkedList <CandyItem>();
        int total_weight = 0;
        for (var it: _items){
            if (it.getSugarWeight() >= min_sugar && it.getSugarWeight() <+ max_sugar)
                acceptable_candy.add(it);
        }
        return acceptable_candy;
    }

    public void sortItemsBy(Comparator<CandyItem> sort_cmp){
        _items.sort(sort_cmp);
    }

    public List<CandyItem> getItems(){return _items;}
}
