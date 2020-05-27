package com.example.volleyball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

class Area {

    private RectF rect;
    private boolean selected;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    Area(RectF rect, int side, float density) {
        this.rect = rect;
    }

    public RectF getRect() {
        return rect;
    }

    void draw(Canvas canvas, Paint paint) {
        if (selected) {
            paint.setColor(Color.RED);
        }
        canvas.drawRect(rect, paint);
        paint.setColor(Color.BLACK);

    }

    void setSelected(boolean value) {
        selected = value;
    }

    public boolean isSelected() {
        return selected;
    }
}
