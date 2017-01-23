package com.example.jongkook.chap04_event_severalevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Myview view;

    // Vertex 클래스
    // 정점 하나에 대한 정보를 가지는 클래스
    public class Vertex{
        float x, y;
        // draw : 선을 그을 것인지 이동만 할 것인지.
        boolean draw;
        public Vertex(float ax, float ay, boolean ad) {
            x = ax;
            y = ay;
            draw = ad;
        }
    }

    // 곡선을 구성하는 점의 갯수는 제한이 없으므로 고정크기 배열 사용 X
    // 추가만 되고 삽입, 삭제 없어 --> ArrayList
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
            // setAntiAlias : 부드럽게 그리기 위함
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);

            // 정점을 순회하면서 선분으로 잇는다
            // i = 0 일때는 draw 멤버가 항상 false
            for(int i = 0;i<arVertex.size();i++){
                if(arVertex.get(i).draw){
                    Log.i("onDraw","----- "+i);
                    canvas.drawLine(arVertex.get(i-1).x, arVertex.get(i-1).y
                        ,arVertex.get(i).x, arVertex.get(i).y, paint);
                }
            }
        }

        // 뷰를 터치하거나 이동할 때 발생하는 터치 이벤트
        // draw 멤버 변수 구분을 위한 이벤트
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                arVertex.add(new Vertex(event.getX(), event.getY(), false));
                return true;
            }
            if(event.getAction() == MotionEvent.ACTION_MOVE){
                arVertex.add(new Vertex(event.getX(), event.getY(), true));
                // invalidate : 새로 추가된 선을 출력하기 위함
                // 전체 뷰를 무효 - 화면을 갱신
                invalidate();
                // 직후 onDraw 호출
                return true;
            }
            return false;
        }
    }
}


