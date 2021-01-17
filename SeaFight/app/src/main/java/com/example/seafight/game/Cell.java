package com.example.seafight.game;

import com.example.seafight.game.ship.Ship;
import com.example.seafight.game.ship.ShipState;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


//TODO restrict user from placing shipUnits randomly
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
    }

    boolean attacked = false;
    ShipUnit shipUnit;

    @Nullable
    public ShipState getShipState(){
        if (this.shipUnit ==  null){
            return null;
        }
        return this.shipUnit.ship.getState();
    }

    public boolean isAttacked() {
        return attacked;
    }

    public boolean attack() {
        if (this.attacked || this.shipUnit == null){
            return false;
        }
        this.attacked = true;
        return this.shipUnit.attack();
    }

    public void setShipUnit(@NotNull Ship ship, int unitNo) {
        this.shipUnit = new ShipUnit(ship, unitNo);
    }
}
