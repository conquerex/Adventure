package com.example.jongkook.chap04_event_severalevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by jongkook on 2017. 1. 25..
 */

public class Myview2 extends View{
    float mX, mY;
    int mColor;

    public Myview2(Context context) {
        super(context);
        mX = 100;
        mY = 100;
        mColor = Color.BLUE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);
        Paint paint = new Paint();
        paint.setColor(mColor);
        paint.setAntiAlias(true);
        canvas.drawCircle(mX,mY,16,paint);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch (keyCode){
                case KeyEvent.KEYCODE_A:
                    mX -= 5;
                    invalidate();
                    return true;
                case KeyEvent.KEYCODE_D:
                    mX += 5;
                    invalidate();
                    return true;
                case KeyEvent.KEYCODE_W:
                    mY -= 5;
                    invalidate();
                    return true;
                case KeyEvent.KEYCODE_S:
                    mY += 5;
                    invalidate();
                    return true;
                case KeyEvent.KEYCODE_SPACE:
                    if (mColor == Color.BLUE){
                        mColor = Color.RED;
                    } else {
                        mColor = Color.BLUE;
                    }
                    invalidate();
                    return true;
            }
        }
        return false;
    }
}
