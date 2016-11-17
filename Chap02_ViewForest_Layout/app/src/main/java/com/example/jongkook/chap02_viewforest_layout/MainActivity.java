package com.example.jongkook.chap02_viewforest_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View mPage1, mPage2, mPage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPage1 = findViewById(R.id.page1);
        mPage2 = findViewById(R.id.page2);
        mPage3 = findViewById(R.id.page3);

        findViewById(R.id.btnPage1).setOnClickListener(mClickLitener);
        findViewById(R.id.btnPage2).setOnClickListener(mClickLitener);
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
