package com.example.jongkook.chap04_event_severalevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Myview view;
    private Myview2 view2;
    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
    }
}
