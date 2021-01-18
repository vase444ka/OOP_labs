package com.example.seafight.game.ship;

import java.util.ArrayList;
import java.util.Collections;

public class Ship {
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;

    ArrayList <Boolean> unitIsHit;
    private boolean positioned = false;

    public Ship(){
        unitIsHit = new ArrayList<>();
        unitIsHit.add(Boolean.FALSE);
    }

    public Ship(int length){
        if ((length < MIN_LENGTH) || (length > MAX_LENGTH)){
            throw new IllegalArgumentException("Ship size must be between 1 and 5");
        }
        unitIsHit = new ArrayList<>(Collections.nCopies(length, Boolean.FALSE));
    }

    public Boolean getUnit(int i) {
        if ((i < 0) || (i >= unitIsHit.size())){
            throw new IllegalArgumentException("getting inexistent unit");
        }
        return unitIsHit.get(i);
    }

    public void hitUnit(int i) {
        if ((i < 0) || (i >= unitIsHit.size())){
            throw new IllegalArgumentException("hitting inexistent unit");
        }
        unitIsHit.set(i, Boolean.TRUE);
    }

    public ShipState getState(){
        int hitUnitsCount = 0;
        for (Boolean hitUnit: unitIsHit){
            if (hitUnit){
                hitUnitsCount++;
            }
        }
        if (hitUnitsCount == 0){
            return ShipState.SOLID;
        }
        if (hitUnitsCount == unitIsHit.size()){
            return ShipState.KILLED;
        }
        return ShipState.HIT;
    }

    public int getLength(){
        return unitIsHit.size();
    }

    public boolean isPositioned() {
        return positioned;
    }

    public void position() {
        this.positioned = true;
    }
}
