package com.example.seafight;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class RenderingThread extends Thread {
    private GameView gameView;//this is really bad for a simple view. What about SurfaceView?
    private boolean running;
    public static Canvas canvas;//wondering why is this static

    public RenderingThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.gameView = gameView;
        System.out.println("---RenderingThread created---");
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;
            canvas = gameView.getHolder().lockCanvas();
            try {
                synchronized (this) {
                    this.gameView.draw(canvas);
                }
            } catch (Exception e) {
            } finally {
                if (canvas != null) {
                    try {
                        gameView.getHolder().unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }
}
