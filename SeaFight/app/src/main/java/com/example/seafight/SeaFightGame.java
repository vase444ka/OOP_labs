package com.example.seafight;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

public class SeaFightGame {
    ArrayList<PlayerItems> Player;

    public SeaFightGame(){
        Player.add(new PlayerItems(/*flag??*/));
        Player.add(new PlayerItems(/*flag2??*/));
    }

    public void draw(Canvas canvas){
        for (PlayerItems it: Player)
            it.draw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(250, 0, 0));
        canvas.drawRect(canvas.getWidth()/4, canvas.getHeight()/4, canvas.getWidth()/4*3, canvas.getHeight()/4*3, paint);
    }
}
