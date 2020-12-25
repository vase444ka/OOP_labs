package Packaging;

public class CandyWrapper {
    private Material _material;
    private double _complexity_multiplier;

    public CandyWrapper(){
        _material = Material.NONE;
        _complexity_multiplier = 1;
    }

    public CandyWrapper(Material material, double complexity) throws IllegalArgumentException{
        if (complexity < 1){
            throw new IllegalArgumentException();
        }
        _material = material;
        _complexity_multiplier = complexity;
    }

    public int countPrice(int wrappedItemWeight){
        return (int) Math.ceil(_material.getCostPerGram()*wrappedItemWeight*_complexity_multiplier);
    }
}
