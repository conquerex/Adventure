package com.example.jongkook.chap02_viewforest_layoutparams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button)findViewById(R.id.button);
        btnRight = (Button)findViewById(R.id.button2);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParam(1,3);
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParam(3,1);
            }
        });
    }

    void setParam(int left, int right){
        LinearLayout.LayoutParams lparam =
                (LinearLayout.LayoutParams)btnLeft.getLayoutParams();
        LinearLayout.LayoutParams rparam =
                (LinearLayout.LayoutParams)btnRight.getLayoutParams();
        lparam.weight = left;
        rparam.weight = right;

        btnLeft.setLayoutParams(lparam);
        btnRight.setLayoutParams(rparam);
    }
}
