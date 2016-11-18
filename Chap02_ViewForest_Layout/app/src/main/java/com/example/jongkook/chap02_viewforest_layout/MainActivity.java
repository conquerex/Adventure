package com.example.jongkook.chap02_viewforest_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout mPage1;
    View mPage2, mPage3;
    // 추가할 텍스트뷰
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPage1 = (LinearLayout) findViewById(R.id.page1);
        // 수직을 수평으로 세팅
        mPage1.setOrientation(LinearLayout.HORIZONTAL);

        // textView 정의
        textView = new TextView(this);
        textView.setText("add Text");
        // textView.setGravity(Gravity.RIGHT);
        textView.setTextSize(20);
        mPage1.addView(textView);

        mPage2 = findViewById(R.id.page2);
        mPage3 = findViewById(R.id.page3);

        findViewById(R.id.btnPage1).setOnClickListener(mClickLitener);
        findViewById(R.id.btnPage2).setOnClickListener(mClickLitener);
        Button btn = (Button)findViewById(R.id.btnPage2);
        // 텍스트 박스 사이즈 변경 (반드시 선언 후 변경)
        btn.setTextSize(40);
        findViewById(R.id.btnPage3).setOnClickListener(mClickLitener);

    }

    Button.OnClickListener mClickLitener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            mPage1.setVisibility(View.INVISIBLE);
            mPage2.setVisibility(View.INVISIBLE);
            mPage3.setVisibility(View.INVISIBLE);

            switch (view.getId()){
                case R.id.btnPage1:
                    mPage1.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnPage2:
                    mPage2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnPage3:
                    mPage3.setVisibility(View.VISIBLE);
                    break;

            }
        }
    };
}
