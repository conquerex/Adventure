package com.example.jongkook.chap04_event_whatfirst;

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
        View view = new MyView(this);
        // 리스너 - 1순위
        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    Toast.makeText(MainActivity.this, "Listener : Touch event received", Toast.LENGTH_SHORT).show();
                    // 모든 true 리턴을 주석처리하면
                    // 우선수위별로 Toast가 출력 됨
                    return true;
                }
                // false가 리턴될 경우 아직 처리되지 못했으므로
                // 다음 순위의 메서드가 호출되어 남은 처리를 하게 됨
                return false;
            }
        });
        setContentView(view);
    }

    protected class MyView extends View{
        public MyView(Context context) {
            super(context);
        }

        // 뷰의 콜백 메서드 - 2순위
        // onTouchEvent의 event 인수 : 뷰의 좌상단을 기준으로한 좌표
        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                Toast.makeText(MainActivity.this, "View : Touch event received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    // 액티비티의 콜백 메서드 - 3순위
    // onTouchEvent의 event 인수 : 액티비티의 좌상단을 기준으로한 좌표
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(MainActivity.this, "Activity : Touch event received", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
