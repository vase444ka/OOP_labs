package com.example.seafight.game.player;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.seafight.game.Cell;
import com.example.seafight.game.ship.ShipState;

public abstract class DrawingStrategy {
    public abstract void draw(Cell cell, Canvas canvas, int topLeftX, int topLeftY, int cellSize);
    protected void drawOpenCell(Cell cell, Canvas canvas, int topLeftX, int topLeftY, int cellSize){
        Paint paint = new Paint();
        ShipState shipState = cell.getState();
        if (shipState == null)
            paint.setColor(Color.CYAN);
        else{
            paint.setColor(shipState.getColor());
        }
        canvas.drawRect(topLeftX, topLeftY,
                topLeftX + cellSize, topLeftY + cellSize, paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(cellSize/10);
        canvas.drawRect(topLeftX, topLeftY,
                topLeftX + cellSize, topLeftY + cellSize, paint);
    }
}
