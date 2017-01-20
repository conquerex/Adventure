package com.example.jongkook.chap04_event_severalevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Myview view;
    // 정점 하나에 대한 정보를 가지는 클래스
    public class Vertex{
        float x, y;
        boolean draw;
        public Vertex(float ax, float ay, boolean ad) {
            x = ax;
            y = ay;
            draw = ad;
        }
    }

    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new Myview(this);
        setContentView(view);

        arVertex = new ArrayList<Vertex>();
    }

    protected class Myview extends View {
        Paint paint;

        public Myview(Context context) {
            super(context);
            // Pain 초기화
            paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(3);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);

            // 정점을 순회하면서 선분으로 잇는다
            for(int i = 0;i<arVertex.size();i++){
                if(arVertex.get(i).draw){
                    canvas.drawLine(arVertex.get(i-1).x, arVertex.get(i-1).y
                        ,arVertex.get(i).x, arVertex.get(i).y, paint);
                }
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE){
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                invalidate();
                return true;
            }
            return false;
        }
    }
}


