package com.example.volleyball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class Button {

    private RectF rect;

    Bitmap bitmap;

    Button(Context context, RectF rect) {
        this.rect = new RectF(rect);
    }

    void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(rect, paint);
    }

    public RectF getRect() {
        return rect;
    }
}
