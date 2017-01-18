package com.example.jongkook.chap04_event_whatfirst;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**  외부 변수 액세스 실습 코드 - 시작  **/
        setContentView(R.layout.activity_main);
        LinearLayout linear = (LinearLayout)findViewById(R.id.activity_main);
        tv = (TextView)findViewById(R.id.tvText);

        // onCreate 내에 정의된 내부클래스(OnTouchListener의 익명 서브클래스)는
        // final이 아닌 변수를 참조할 수 없다.
        // outText는 onCreate가 리턴되면 사라지는 지역변수
        // 하지만 onTouch는 이벤트 발생시 언제든지 호출가능.
        // 상수(final)가 되어 onTouch를 등록하는 시점에 그 값을 전달
        // ** 리스너로 전달할 지역 변수는 final로 선언한다
        final TextView outText = (TextView)findViewById(R.id.tvText);

        linear.setOnTouchListener(new View.OnTouchListener(){
            @Override
            // onTouch 메서드는 onCreate에 속한 지역 메서드가 아님
            // 터치 이벤트 발생시 실행할 메서드로 등록만 할
            // onTouch 메서드가 속한 객체는 익명의 리스너 타입
            // onCreate 메서드 내에 선언된 로컬 내부 클래스
            //  - 내부클래스는 외부 클래스와 긴밀하게 연관. 외부 클래스의 멤버를 참조할 수 있다
            //  - 리스너 내에서 액티비티의 findviewById
            //  - 텍스트뷰 객체를 따로 선언해도 된다. 더 효율적. 매번 검새갈 필요 없음.
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    // TextView tv = (TextView)findViewById(R.id.tvText);
                    outText.setText("Touched");
                    return true;
                }
                return false;
            }
        });

        /**  외부 변수 액세스 실습 코드 - 끝  **/


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
        /**  외부 변수 액세스 실습 코드 - 아래 주석처리  **/
        // setContentView(view);
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
