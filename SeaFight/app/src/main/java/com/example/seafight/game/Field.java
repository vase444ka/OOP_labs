package com.example.seafight.game;

//TODO find out if new cells are being created here
public class Field {
    public static final int SIZE = 10, MARGIN = 1;
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
}