package main.candy;

public abstract class AbstractSolidCandy implements CandyItem{
    private int weight, sugarWeight, calories, price;

    public AbstractSolidCandy(int weight, int sugar_weight, int calories, int price){
        this.weight = weight;
        this.sugarWeight = sugar_weight;
        this.calories = calories;
        this.price = price;
    }

    @Override
    public int getWeight(){ return weight;}

    @Override
    public int getSugarWeight(){ return sugarWeight;}

    @Override
    public int getCalories(){ return calories;}

    @Override
    public int getPrice(){ return price;}
}
