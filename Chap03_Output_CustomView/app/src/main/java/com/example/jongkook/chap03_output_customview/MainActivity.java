package com.example.jongkook.chap03_output_customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView view = new MyView(this);
        //setContentView(R.layout.activity_main);
        setContentView(view);
    }

    // MyView라는 이름의 커스텀뷰
    class MyView extends View{

        // 생성자는 상속되지 않음
        // 부모가 디폴트 생성자를 제공하지 않는 한 직접 정의
        public MyView(Context context) {
            // 부모의 생성자만 호출하면 되기에 아래처럼 구현
            super(context);
        }

        public void onDraw(Canvas canvas){
            canvas.drawColor(Color.LTGRAY);
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            // 수치는 모두 픽셀 px 단위
            canvas.drawCircle(100,100,80,paint);
        }
    }
}
