package Candy;

public abstract class AbstractWeighedCandy implements CandyItem{
    private int _weight, _sugar_percentage, _calories_per_100_gramm, _price_per_100_gramm;

    @Override
    public int getWeight(){ return _weight;}

    @Override
    public int getSugarWeight(){
        return (int) Math.ceil(_sugar_percentage*_weight/100.0);
    }

    @Override
    public int getCalories(){
        return (int)Math.ceil(_calories_per_100_gramm*_weight/100.0);
    }

    @Override
    public int getPrice(){
        return (int)Math.ceil(_price_per_100_gramm*_weight/100.0);
    }
}
