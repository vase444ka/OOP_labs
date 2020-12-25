package Gift;

public enum Material {
    PAPER(2),
    PLASTIC(1),
    WOOD(3),
    POLYMER(1),
    FOIL(2),
    NONE(0);
    private int _cost_per_gram;//cents

    Material(int cost) {
        _cost_per_gram = cost;
    }

    int getCostPerGram(){return _cost_per_gram;}
}
