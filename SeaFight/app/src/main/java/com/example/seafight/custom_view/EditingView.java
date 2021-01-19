package com.example.seafight.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.seafight.game.Field;
import com.example.seafight.game.player.Player;

import org.jetbrains.annotations.Nullable;

public class EditingView extends SurfaceView implements android.view.SurfaceHolder.Callback{
    private RenderingThread thread;
    private Player player;
    private int startI, startJ;

    public EditingView(Context context) {
        super(context);
    }

    public EditingView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        System.out.println("--editingView constructor---");
    }

    public EditingView(Context context, @Nullable AttributeSet attrs,
                    int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow(){
        super.onAttachedToWindow();
        getHolder().addCallback(this);
        setFocusable(true);
        System.out.println("---editview attached to window---");
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        System.out.println("---gameView surface created---");
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
        if (canvas != null && player != null) {
            player.draw(canvas,
                    new Point(0, 0), getWidth(), getHeight());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if ((event.getAction() != MotionEvent.ACTION_DOWN) &&
                (event.getAction() != MotionEvent.ACTION_UP)){
            return true;
        }
        int cellSize = Math.min(getHeight(), getWidth())/(Field.SIZE + 2*Field.MARGIN + 2);
        Point fieldTopLeft = new Point
                (getWidth()/2 - cellSize*Field.SIZE/2,
                        getHeight()/2 - cellSize*Field.SIZE/2);

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            this.startI = (int) (event.getY() - fieldTopLeft.y)/cellSize;
            this.startJ = (int) (event.getX() - fieldTopLeft.x)/cellSize;
        }
        if (event.getAction() == MotionEvent.ACTION_UP){
            int endI = (int) (event.getY() - fieldTopLeft.y)/cellSize;
            int endJ = (int) (event.getX() - fieldTopLeft.x)/cellSize;
            if ((startI < 0) || (startJ < 0) ||
                    (startI >= Field.SIZE) || (startJ >= Field.SIZE) ||
                    (endI < 0) || (endJ < 0) ||
                    (endI >= Field.SIZE) || (endJ >= Field.SIZE)){
                return true;
            }

            if (startI == endI){
                player.placeShip(startI, Math.min(endJ, startJ), Math.abs(endJ - startJ) + 1, false);
            }
            else if (startJ == endJ){
                player.placeShip(Math.min(startI, endI), startJ, Math.abs(endI - startI) + 1, true);
            }
        }
        return !player.isReady();
    }//when positionedShips == player.shipsN, changeView
}
