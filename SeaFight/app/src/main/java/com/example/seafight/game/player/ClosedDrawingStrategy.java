package com.example.seafight.game.player;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.seafight.game.Cell;

public class ClosedDrawingStrategy extends DrawingStrategy {
    @Override
    public void draw(Cell cell, Canvas canvas, int topLeftX, int topLeftY, int cellSize) {
        if (!cell.isAttacked()){
            Paint paint = new Paint();
            paint.setColor(Color.LTGRAY);
            canvas.drawRect(topLeftX, topLeftY,
                    topLeftX + cellSize, topLeftY + cellSize, paint);
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(cellSize/10);
            canvas.drawRect(topLeftX, topLeftY,
                    topLeftX + cellSize, topLeftY + cellSize, paint);
        }
        else {
            super.drawOpenCell(cell, canvas, topLeftX, topLeftY, cellSize);
        }
    }
}
