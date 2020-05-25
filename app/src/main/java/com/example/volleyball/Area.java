package com.example.volleyball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class Area {

    private RectF rect;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    Area(RectF rect, int side, float density) {
        this.rect = rect;
    }

    void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(rect, paint);
    }
}
