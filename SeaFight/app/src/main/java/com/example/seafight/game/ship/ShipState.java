package com.example.seafight.game.ship;

import android.graphics.Color;

public enum ShipState {
    SOLID, HIT, KILLED;

    public int getColor(){
        if (this == SOLID)
            return Color.GREEN;
        if (this == HIT)
            return Color.YELLOW;
            return Color.RED;
    }
}
