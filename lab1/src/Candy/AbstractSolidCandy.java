package Candy;

public abstract class AbstractSolidCandy implements CandyItem{
    private int _weight, _sugar_weight, _calories, _price;

    @Override
    public int getWeight(){ return _weight;}

    @Override
    public int getSugarWeight(){ return _sugar_weight;}

    @Override
    public int getCalories(){ return _calories;}

    @Override
    public int getPrice(){ return _price;}
}
