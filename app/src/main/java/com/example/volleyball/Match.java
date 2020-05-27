package com.example.volleyball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.ScaleAnimation;
import android.widget.Switch;

class Match extends SurfaceView implements Runnable {

    private Thread thread;
    private volatile boolean playing;
    private boolean paused = true;
    private boolean gameOver = false;

    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;
    private Paint paintArea;

    private long fps;
    private final int MS_IN_SECOND = 1000;

    private int width;
    private int height;
    private float screenDensity;
    private float blockSize;
    private float fontSize;
    private float fontMargin;

    private long startTime;

    private Area leftArea;
    private Area rightArea;

    private int leftScore;
    private int rightScore;
    private boolean selectedWho = false;

    private Ball ball;
    private float startBallX;
    private float startBallY;

    Match(Context context, int width, int height, float density) {
        super(context);
        
        this.width = width;
        this.height = height;
        screenDensity = density;
        fontSize = 24 * density;
        fontMargin = fontSize;
        blockSize = height / 5;
        
        holder = getHolder();
        paint = new Paint();
        paintArea = new Paint();
        paintArea.setStrokeWidth(5 * density);
        paintArea.setStyle(Paint.Style.STROKE);

        float halfW = width / 2;

        RectF rectLeft = new RectF(halfW - 3 * blockSize, height - 4 * blockSize, halfW, height - blockSize);
        RectF rectRight = new RectF(halfW, rectLeft.top, halfW + 3 * blockSize, rectLeft.bottom);
        leftArea = new Area(rectLeft, Area.LEFT, density);
        rightArea = new Area(rectRight, Area.RIGHT, density);

        startBallX = width / 2;
        startBallY = height / 2;
        ball = new Ball(getContext(), density);

        startGame();
    }

    private void startGame() {
        leftScore = 0;
        rightScore = 0;
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


            leftArea.draw(canvas, paintArea);
            rightArea.draw(canvas, paintArea);

            if (selectedWho) {
                ball.draw(canvas, paint);
            }

            paint.setTextSize(fontSize);
            canvas.drawText("FPS: " + fps, fontMargin, fontSize + fontMargin, paint);

            canvas.drawText("" + leftScore + " : " + rightScore, fontMargin, fontSize * 2 + fontMargin * 2, paint);

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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                if (selectedWho) {
                    ball.setPosition(event.getX(), event.getY());
                } else {
                    if (leftArea.getRect().contains(event.getX(), event.getY())) {
                        selectedWho = true;
                        leftArea.setSelected(true);
                        resetBallPosition();
                    } else if (rightArea.getRect().contains(event.getX(), event.getY())) {
                        selectedWho = true;
                        rightArea.setSelected(true);
                        resetBallPosition();
                    }
                }

                break;
        }
        return true;
    }

    private void resetBallPosition() {
        ball.setPosition(startBallX, startBallY);
    }
}
