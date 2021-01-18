package com.example.seafight.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.seafight.game.player.*;

import java.util.ArrayList;

public class SeaFightGame {
    public Player human, computer;
    public MoveGenerator moveGenerator;

    public SeaFightGame(){
        human = new Player();
        human.setDrawingStrategy(new OpenDrawingStrategy());
        computer = new Player();
        computer.setDrawingStrategy(new ClosedDrawingStrategy());
        moveGenerator = new MoveGenerator();
        human.registerGeneratorAsManager(moveGenerator);
        computer.registerGeneratorAsManager(moveGenerator);
    }
}
