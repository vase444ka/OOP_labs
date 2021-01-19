package main.gift;

public enum Material {
    PAPER(2),
    PLASTIC(1),
    WOOD(3),
    POLYMER(1),
    FOIL(2),
    NONE(0);
    private int costPerGram;//cents

    Material(int cost) {
        costPerGram = cost;
    }

    int getCostPerGram(){return costPerGram;}
}
