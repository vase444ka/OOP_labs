package gift;

public class CandyWrapper {
    private Material material;
    private double complexityMultiplier;

    public CandyWrapper(){
        material = Material.NONE;
        complexityMultiplier = 1;
    }

    public CandyWrapper(Material material, double complexity) throws IllegalArgumentException{
        if (complexity < 1){
            throw new IllegalArgumentException();
        }
        this.material = material;
        complexityMultiplier = complexity;
    }

    public int countPrice(int wrappedItemWeight){
        return (int) Math.ceil(material.getCostPerGram()*wrappedItemWeight* complexityMultiplier);
    }
}
