package com.example.seafight.game;

import android.util.Pair;

public class MoveGenerator {
    private Field myField, opponentField;

    public void setMyField(Field field){
        myField = field;
    }

    public void setOpponentField(Field opponentField) {
        this.opponentField = opponentField;
    }

    public Pair<Integer, Integer> generateAttack(){
        return new Pair<>(0, 0);
    }
}
