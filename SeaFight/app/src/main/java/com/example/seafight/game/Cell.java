package com.example.seafight.game;

import com.example.seafight.game.ship.Ship;
import com.example.seafight.game.ship.ShipState;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Cell {
    private static class ShipUnit{
        Ship ship;
        int unitNo;
        public ShipUnit(Ship ship, int unitNo){
            if ((unitNo < 0) || (unitNo >= ship.getLength()) || (ship == null)){
                throw new IllegalArgumentException("placing inexistent ship unit");
            }
            this.ship = ship;
            this.unitNo = unitNo;
        }
        public boolean attack(){
            if (this.ship == null){
                return false;
            }
            this.ship.hitUnit(this.unitNo);
            return true;
        }
        public boolean get(){
            return ship.getUnit(unitNo);
        }
    }

    boolean attacked = false;
    ShipUnit shipUnit;

    @Nullable
    public ShipState getState(){
        if (this.shipUnit ==  null){
            return null;
        }
        ShipState state = this.shipUnit.ship.getState();
        if (state == ShipState.HIT){
            return this.shipUnit.get() ? ShipState.HIT : ShipState.SOLID;
        }
        return state;
    }

    public boolean isAttacked() {
        return attacked;
    }

    public boolean attack() {
        if (this.attacked){
            return false;
        }
        this.attacked = true;
        if (this.shipUnit != null)
            return this.shipUnit.attack();
        else
            return false;
    }

    public void setShipUnit(@NotNull Ship ship, int unitNo) {
        this.shipUnit = new ShipUnit(ship, unitNo);
    }
}
