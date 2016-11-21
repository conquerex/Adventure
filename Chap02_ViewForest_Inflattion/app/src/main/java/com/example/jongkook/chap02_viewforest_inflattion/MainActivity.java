package com.example.jongkook.chap02_viewforest_inflattion;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메인에 Button 하나만 추가
        btnNew = (Button)findViewById(R.id.btnNewMessage);
        btnNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // 전개자를 통해 mewmessage 가져오기
                RelativeLayout relativeLayout = (RelativeLayout)View.inflate(
                        MainActivity.this, R.layout.mewmessage, null);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);

                // 행별로 색을 다르게 보이기 위한 설정
                if (linearLayout.getChildCount() % 2 == 0){
                    relativeLayout.setBackgroundColor(Color.GRAY);
                }else{
                    relativeLayout.setBackgroundColor(Color.YELLOW);
                }

                // 전개자로 가져온 것을 main의 레이아웃에 붙인다
                linearLayout.addView(relativeLayout);
            }
        });
    }
}
