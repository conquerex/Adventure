package com.example.jongkook.chap02_viewforest_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    EditText editText;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼뷰 정의
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        img = (ImageView)findViewById(R.id.imageView);

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

        // 버튼을 클릭할 때마다 이미지뷰가 사라지고 나타남이 반복된다
        // layout_alignWithParentIfMissing 실습
        // 이미지가 사라질 경우 텍스트뷰는 부모뷰
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility() == View.VISIBLE){
                    img.setVisibility(View.GONE);
                }else{
                    img.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
