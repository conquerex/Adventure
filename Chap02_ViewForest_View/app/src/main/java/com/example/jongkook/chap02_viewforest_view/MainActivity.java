package com.example.jongkook.chap02_viewforest_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼뷰 정의
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 에디트텍스트뷰 정의
                editText = (EditText)findViewById(R.id.editText);
                String str = editText.getText().toString();
                // 토스트 메시지로 버튼 이벤트 확인
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
