package com.example.seafight.game.player;

import android.graphics.Canvas;

import com.example.seafight.game.Cell;

public class OpenDrawingStrategy extends DrawingStrategy {
    @Override
    public void draw(Cell cell, Canvas canvas, int topLeftX, int topLeftY, int cellSize) {
        super.drawOpenCell(cell, canvas, topLeftX, topLeftY, cellSize);
    }
}
