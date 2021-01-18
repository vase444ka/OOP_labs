package com.example.seafight;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class RenderingThread extends Thread {
    private SurfaceView view;//this is really bad for a simple view. What about SurfaceView?
    private boolean running;
    public static Canvas canvas;//wondering why is this static

    public RenderingThread(SurfaceHolder surfaceHolder, SurfaceView view) {
        super();
        this.view = view;
        System.out.println("---RenderingThread created---");
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;
            canvas = view.getHolder().lockCanvas();
            try {
                synchronized (this) {
                    this.view.draw(canvas);
                }
            } catch (Exception e) {
            } finally {
                if (canvas != null) {
                    try {
                        view.getHolder().unlockCanvasAndPost(canvas);
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
