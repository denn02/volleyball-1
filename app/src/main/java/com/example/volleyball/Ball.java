package com.example.volleyball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class Ball {

    private RectF rect;
    private float positionX;
    private float positionY;
    private float width;
    private float height;
    private Bitmap bitmap;

    Ball(Context context, float density) {
        width = 50 * density;
        height = 50 * density;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ball);
        bitmap = Bitmap.createScaledBitmap(bitmap, (int) width, (int) height, false);
    }

    void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(bitmap, positionX, positionY, paint);
    }

    void setPosition(float x, float y) {
        positionX = x - width / 2;
        positionY = y - height / 2;
    }
}
