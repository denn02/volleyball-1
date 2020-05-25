package com.example.volleyball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.ScaleAnimation;

class Match extends SurfaceView implements Runnable {

    private Thread thread;
    private volatile boolean playing;
    private boolean paused = true;
    private boolean gameOver = false;

    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;

    private long fps;
    private final int MS_IN_SECOND = 1000;

    private int width;
    private int height;
    private float screenDensity;
    private float fontSize;
    private float fontMargin;

    private long startTime;

    Match(Context context, int width, int height, float density) {
        super(context);
        
        this.width = width;
        this.height = height;
        screenDensity = density;
        fontSize = 24 * density;
        fontMargin = fontSize;
        
        holder = getHolder();
        paint = new Paint();

        startGame();
    }

    private void startGame() {
        paused = false;
        gameOver = false;
        startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while(playing) {
            long startFrame = System.currentTimeMillis();

            if (!paused) {
                update();
            }

            draw();

            long timeFrame = System.currentTimeMillis() - startFrame;
            if (timeFrame > 0) {
                fps = MS_IN_SECOND / timeFrame;
            }
        }

    }

    private void update() {
    }

    private void draw() {
        if(holder.getSurface().isValid()) {
            canvas = holder.lockCanvas();

            canvas.drawColor(Color.GRAY);

            paint.setTextSize(fontSize);
            canvas.drawText("FPS: " + fps, fontMargin, fontSize + fontMargin, paint);

            holder.unlockCanvasAndPost(canvas);
        }

    }

    public void pause() {
        playing = false;
        try {
            thread.join();
        } catch(Exception e) {
            // Error;
        }
    }

    public void resume() {
        playing = true;
        thread = new Thread(this);
        thread.start();
    }
}
