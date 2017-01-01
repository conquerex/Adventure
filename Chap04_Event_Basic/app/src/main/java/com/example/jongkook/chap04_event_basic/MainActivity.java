package com.example.jongkook.chap04_event_basic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


// 이벤트 처리 방법
// 1. 콜백 메서드 정의 : 권장하지 않는 방식
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MyView를 콘텐츠 뷰로 등록하므로
        // 화면 전체를 MyView로 가득 채워진다
//        View view = new MyView(this);
//        setContentView(view);

        // 리스너 등록
        // c. 준비된 리스너 객체를 뷰의 이벤트와 연결
        View view = new View(this);
        view.setOnTouchListener(touchListenerClass);
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
                Toast.makeText(MainActivity.this, "Touch Event received -- 1",
                        Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        }
    }

    // 2. 리스너 인터페이스 구현
    // 리스너 Listener
    // ex) View 클래스의 내부 인터페이스 - OnTouchListener 인터페이스가 선언
    // 이 인터페이스는 onTouch라는 추상 메서드(구현 없음)를 포함 - 이벤트 핸들러

    // a. 리스너를 상속받는 클래스를 선언하고 추상 메서드(onTouch)를 구현
    class TouchListenerClass implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(MainActivity.this, "Touch Event Received -- 2",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    // b. 리스너 객체를 생성
    TouchListenerClass touchListenerClass = new TouchListenerClass();

}


