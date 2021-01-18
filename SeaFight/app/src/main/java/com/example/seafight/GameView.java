package com.example.seafight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

import com.example.seafight.game.Field;
import com.example.seafight.game.SeaFightGame;
import com.example.seafight.game.player.*;

import org.jetbrains.annotations.Nullable;

public class GameView extends SurfaceView implements android.view.SurfaceHolder.Callback {
    private RenderingThread thread;
    private SeaFightGame gameInstance;
    private Point humanTopLeft, computerTopLeft;
    private int playerViewHeight, playerViewWidth;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        System.out.println("--gameView constructor---");
    }

    public GameView(Context context, @Nullable AttributeSet attrs,
                    int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow(){
        super.onAttachedToWindow();
        getHolder().addCallback(this);
        setFocusable(true);
        System.out.println("---gameview attached to window---");
    }

    public void setGameInstance(SeaFightGame gameInstance) {
        this.gameInstance = gameInstance;
        System.out.println("---game instance set to view---");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("---gameView surface created---");
        playerViewHeight = this.getHolder().getSurfaceFrame().height()/2;
        playerViewWidth = this.getHolder().getSurfaceFrame().width();
        humanTopLeft = new Point(0, 0);
        computerTopLeft = new Point(0, playerViewHeight);
        thread = new RenderingThread(this.getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null && gameInstance != null) {
            gameInstance.human.draw(canvas,
                    humanTopLeft, getWidth(), getHeight()/2);
            gameInstance.computer.draw(canvas,
                    computerTopLeft, getWidth(), getHeight()/2);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN){
            return true;
        }
        if (gameInstance == null){
            return true;
        }
        if ((event.getY() < computerTopLeft.y) ||
                (event.getY() > computerTopLeft.y + playerViewHeight)){
            return true;
        }
        int cellSize = Math.min(playerViewHeight, playerViewWidth)/(Field.SIZE + 2*Field.MARGIN + 2);
        Point fieldTopLeft = new Point
                (computerTopLeft.x + playerViewWidth/2 - cellSize*Field.SIZE/2,
                computerTopLeft.y + playerViewHeight/2 - cellSize*Field.SIZE/2);
        int i = (int) (event.getY() - fieldTopLeft.y)/cellSize;
        int j = (int) (event.getX() - fieldTopLeft.x)/cellSize;
        if (i < 0 || j < 0 || i >= Field.SIZE || j >= Field.SIZE){
            return true;
        }
        System.out.println("---" + i + "---" + j + "---");
        if (!gameInstance.computer.attacked(i, j)){
            int generated_i, generated_j;
            //generation goes here
            //while(gameInstance.human.attacked(generated_i, generated_j)){
                //some more generation
            //}
        }

        return true;
    }
}
