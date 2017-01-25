package com.example.jongkook.chap04_event_severalevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by jongkook on 2017. 1. 25..
 */

public class Myview extends View{
    Paint paint;
    // 곡선을 구성하는 점의 갯수는 제한이 없으므로 고정크기 배열 사용 X
    // 추가만 되고 삽입, 삭제 없어 --> ArrayList
    ArrayList<Vertex> arVertex;

    public Myview(Context context) {
        super(context);
//        this.arVertex = arVertex;

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
