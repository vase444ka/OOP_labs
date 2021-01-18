package com.example.seafight.game;

public class Field {
    public static final int SIZE = 10, MARGIN = 0;
    Cell[][] cell = new Cell[SIZE][SIZE];

    public Field(){
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++){
                cell[i][j] = new Cell();
            }
    }

    public Cell getCell(int i, int j){
        if ((i < 0) || (i >= SIZE) || (j < 0) || (j >= SIZE)){
            throw new IllegalArgumentException("getting inexistent cell");
        }
        return cell[i][j];
    }

    public boolean isShipAllowed(int i, int j){
        if ((i < 0) || (i >= SIZE) || (j < 0) || (j >= SIZE)){
            throw new IllegalArgumentException("getting inexistent cell");
        }
        for (int currentJ = j - 1; currentJ <= j + 1; currentJ++)
            for (int currentI = i -1; currentI <= i + 1; currentI++){
                if ((currentI >= 0) && (currentJ >= 0) &&
                        (currentI < SIZE) && (currentJ < SIZE) &&
                        (cell[currentI][currentJ].getState() != null))
                    return false;
            }
        return true;
    }
}
