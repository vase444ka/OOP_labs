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

    public Player(){
        ship = new ArrayList<>();
        for (int len = Ship.MIN_LENGTH; len <= Ship.MAX_LENGTH; len++){
            int amount = Ship.MAX_LENGTH + 1 - len;
            ship.addAll(Collections.nCopies(amount, new Ship(len)));
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
                paint.setColor(Color.rgb(25 * i, 0, 255 - 25 * j));
                canvas.drawRect(x, y,x + cellSize, y + cellSize, paint);
                x += cellSize;
            }
            y += cellSize;
        }
    }//TODO strategy

    public void buildField(){}//TODO
    //true if player can move was hit
    public boolean attacked(int i, int j){
        if ((i < 0) || (i >= Field.SIZE) || (j < 0) || (j >= Field.SIZE)){
            throw new IllegalArgumentException("attacking inexistent cell");
        }
        return field.getCell(i, j).attack();
    }

    public boolean checkLose(){
        for (Ship shipIterator: ship){
            if (shipIterator.getState() != ShipState.KILLED)
                return false;
        }
        return true;
    }
}
