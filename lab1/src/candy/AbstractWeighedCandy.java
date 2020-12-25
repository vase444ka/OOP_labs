package candy;

public abstract class AbstractWeighedCandy implements CandyItem{
    private int weight, sugarPercentage, caloriesPer100Gramm, pricePer100Gramm;

    protected void init(int weight, int sugar, int ccal, int price){
        this.weight = weight;
        this.sugarPercentage = sugar;
        this.caloriesPer100Gramm = ccal;
        this.pricePer100Gramm = price;
    }

    @Override
    public int getWeight(){ return weight;}

    @Override
    public int getSugarWeight(){
        return (int) Math.ceil(sugarPercentage * weight /100.0);
    }

    @Override
    public int getCalories(){
        return (int)Math.ceil(caloriesPer100Gramm * weight /100.0);
    }

    @Override
    public int getPrice(){
        return (int)Math.ceil(pricePer100Gramm * weight /100.0);
    }
}
