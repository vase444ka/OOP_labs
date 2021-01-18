package com.example.seafight.game.player;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.example.seafight.game.*;
import com.example.seafight.game.ship.Ship;
import com.example.seafight.game.ship.ShipState;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    Field field = new Field();
    ArrayList <Ship> ship;
    int placedShips;
    DrawingStrategy drawingStrategy;

    public Player(){
        ship = new ArrayList<>();
        for (int len = Ship.MIN_LENGTH; len <= Ship.MAX_LENGTH; len++){
            for (int count = 0; count < Ship.MAX_LENGTH + 1 - len; count ++)
                ship.add(new Ship(len));
        }
    }

    public void setDrawingStrategy(DrawingStrategy drawingStrategy) {
        this.drawingStrategy = drawingStrategy;
    }

    public void registerGeneratorAsOpponent(MoveGenerator generator){
        if (generator != null){
            generator.setOpponentField(this.field);
        }
    }

    public void registerGeneratorAsManager(MoveGenerator generator){
        if (generator != null){
            generator.setMyField(this.field);
        }
    }

    public void draw(Canvas canvas, Point topLeft, int width, int height){
        int cellSize = Math.min(width, height)/(Field.SIZE + 2*Field.MARGIN + 2);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawRect(topLeft.x, topLeft.y, topLeft.x + width, topLeft.y + height, paint);
        int y = topLeft.y + height/2 - cellSize*Field.SIZE/2;

        for (int i = 0; i < Field.SIZE; i++){
            int x = topLeft.x + width/2 - cellSize*Field.SIZE/2;
            for (int j = 0; j < Field.SIZE; j++) {
                if (drawingStrategy != null) {
                    drawingStrategy.draw(field.getCell(i, j), canvas, x, y, cellSize);
                }
                x += cellSize;
            }
            y += cellSize;
        }
    }

    public boolean placeShip(int startI, int startJ, int shipLength, boolean isVertical){
        if ((startI < 0) || (startI >= Field.SIZE) ||
                (startJ < 0) || (startJ >= Field.SIZE) ||
                (shipLength < Ship.MIN_LENGTH) || (shipLength > Ship.MAX_LENGTH)){
            throw new IllegalArgumentException();
        }
        for (int step = 0; step < shipLength; step++){
            int currentI = startI, currentJ = startJ;
            if (isVertical){
                currentI += step;
            }
            else{
                currentJ += step;
            }
            if (!field.isShipAllowed(currentI, currentJ)){
                return false;
            }
        }
        Ship placedShip = null;
        for (Ship it: ship){
            if (!(it.isPositioned()) && (it.getLength() == shipLength)){
                placedShip = it;
            }
        }
        if (placedShip == null){
            System.out.println("---no ship of size " + shipLength + " found---");
            return false;
        }
        for (int step = 0; step < shipLength; step++){
            int currentI = startI, currentJ = startJ;
            if (isVertical){
                currentI += step;
            }
            else{
                currentJ += step;
            }
            field.getCell(currentI, currentJ).setShipUnit(placedShip, step);
        }
        placedShip.position();
        placedShips++;
        return true;
    }

    //true if player was hit
    public boolean isAttacked(int i, int j){
        if ((i < 0) || (i >= Field.SIZE) || (j < 0) || (j >= Field.SIZE)){
            throw new IllegalArgumentException("attacking inexistent cell");
        }
        return field.getCell(i, j).attack();
    }

    public boolean isReady(){
        return (placedShips == ship.size());
    }

    public boolean isLost(){
        for (Ship shipIterator: ship){
            if (shipIterator.getState() != ShipState.KILLED)
                return false;
        }
        return true;
    }
}
