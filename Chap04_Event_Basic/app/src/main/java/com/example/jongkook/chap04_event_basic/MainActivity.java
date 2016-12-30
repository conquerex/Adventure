package com.example.jongkook.chap04_event_basic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MyView를 콘텐츠 뷰로 등록하므로
        // 화면 전체를 MyView로 가득 채워진다
        View view = new MyView(this);
        setContentView(view);
    }

    class MyView extends View{
        public MyView(Context context) {
            super(context);
        }

        // onTouchEvent 콜백 메서드를 재정의
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // super의 메서드를 호출하여 부모에게 처리기회를 먼저 제공
            super.onTouchEvent(event);

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(MainActivity.this, "Touch Event received",
                        Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        }
    }
}
