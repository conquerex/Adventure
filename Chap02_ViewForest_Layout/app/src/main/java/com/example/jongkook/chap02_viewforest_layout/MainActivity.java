package com.example.jongkook.chap02_viewforest_layout;
// 안프정 p181~203
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
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
        // 2016.11.18 addView 메서드를 사용하여 객체 추가
        mPage1.addView(textView);

        mPage2 = findViewById(R.id.page2);
        mPage3 = findViewById(R.id.page3);

        // 2016.12.21 LayoutInflater : XML 리소스를 전개하여 뷰 객체를 만듦
        /*
        LayoutInflater inflater = (LayoutInflater)getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.layout_sample, null);
        */

        LinearLayout linearLayout = (LinearLayout)View.inflate(this, R.layout.layout_sample, null);
        mPage1.addView(linearLayout);



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
