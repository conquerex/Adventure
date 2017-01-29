package com.example.jongkook.chap04_event_severalevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Myview view;
    private Myview2 view2;
    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2-2. 별도의 리스너 객체를 멤버로 선언 후 해당 멤버를 리스너로 사용
        findViewById(R.id.btnApple).setOnClickListener(listener);
        findViewById(R.id.btnOrange).setOnClickListener(listener);

        // 2-1. 액티비티를 리스너로 사용
        /**
        Button btnApple = (Button)findViewById(R.id.btnApple);
        Button btnOrange = (Button)findViewById(R.id.btnOrange);

        // 개별 리스너의 이벤트를 구현한 방식에서
        // 동일한 코드를 통합한 리팩토링한 케이스
        btnApple.setOnClickListener(this);
        // 액티비티가 onClickListener 인터페이스를 직접 구현했으므로
        // 이 경우 리스너는 액티비티 자신인 this
        // 이전 버전 : setOnClickListener(new Button.OnClickListener){}
        btnOrange.setOnClickListener(this);
         **/

        // 1. 터치 및 키보드 이벤트 실습용 코드
        /**
        // Activity는 뷰 생성
        // View에 대부분 코드를 작성
        view = new Myview(this);
        view2 = new Myview2(this);

        // 키보드 모드로 변환하라. (키보드 모드만 쓸때)
        view2.setFocusable(true);
        // 터치 모드 중에서도 키보드 모드를 사용할 수 있게 하라. (터치,키보드 다중모드 지원할때)
        view2.setFocusableInTouchMode(true);
        setContentView(view2);
        // view.arVertex = new ArrayList<Vertex>();
         **/
    }

    Button.OnClickListener listener = new View.OnClickListener(){
        public void onClick(View view) {
            // 콜백 : 특정 뷰 클래스 소속 - 이벤트 발생 대상이 정해져 있음.
            // 리스너 : 여러 위젯에 의해 공유될 수
            TextView textFruit = (TextView)findViewById(R.id.textFruit);
            switch (view.getId()){
                case R.id.btnApple:
                    textFruit.setText("Apple");
                    break;
                case R.id.btnOrange:
                    textFruit.setText("Orange");
                    break;
            }
        }
    };
}
