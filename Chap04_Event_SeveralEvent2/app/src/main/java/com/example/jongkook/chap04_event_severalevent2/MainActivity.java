package com.example.jongkook.chap04_event_severalevent2;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mCount, value = 0;
    TextView mTextCount, mTextTimer;
    Handler mHandler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 타이머
        mTextTimer = (TextView)findViewById(R.id.tvTimer);

        // 2-1. 빈메시지를 보냄으로써 메서드 호출
        // mHandler.sendEmptyMessage(0);

        // 2-2. 이벤트 리스너를 onCreate 메서드 안에서 지역적으로 초기화
        mHandler2 = new Handler(){
            public void handleMessage(Message msg){
                value++;
                mTextTimer.setText("Value = "+value);
                if(value < 10) mHandler2.sendEmptyMessageDelayed(0, 1000);
            }
        };
        mHandler2.sendEmptyMessage(0);

        // 2-3. CountDownTimer 활용
        // 인수 : 카운트다운 할 총  시간 하번 카운트할 주기(단위)
        new CountDownTimer(10 * 1000, 2000){
            @Override
            public void onTick(long l) {
                value++;
                mTextTimer.setText("Value = "+value);
                if(value == 20) cancel();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        // 1. 롱클릭 : 클릭 등록 메서드로 멤버를 전달
        mTextCount = (TextView)findViewById(R.id.tvCount);
        findViewById(R.id.btnDown).setOnLongClickListener(listener);
        findViewById(R.id.btnUp).setOnLongClickListener(listener);
    }

    // 핸들러 : 스레드간의 메시지 통신을 위한 장치
    Handler mHandler = new Handler(){
        // 메시지는 핸들러의 handleMessage 메서드로 전달되며
        // 여기서 메시지의 의미를 해석해서 필요한 처리를 함
        public void handleMessage(Message msg){
            value++;
            mTextTimer.setText("Value = "+value);
            // 핸들러 자신이 스스로 자신에게 다시 메시지를 보냄. 이때 1초의 지연이 생김
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    public void mOnClick(View v){
        switch (v.getId()){
            case R.id.btnDown:
                mCount--;
                mTextCount.setText(""+mCount);
                break;
            case R.id.btnUp:
                mCount++;
                mTextCount.setText(""+mCount);
                break;
        }
    }

    View.OnLongClickListener listener = new View.OnLongClickListener(){
        public boolean onLongClick(View v){
            switch (v.getId()){
                // true를 반환하므로 0에서 멈춘다
                case R.id.btnDown:
                    mCount = 0;
                    mTextCount.setText(""+mCount);
                    return true;
                // 100으로 세팅 후 false 처리되므로 onClick이 수행되어 101이 출력됨
                case R.id.btnUp:
                    mCount = 100;
                    mTextCount.setText(""+mCount);
                    break;
            }
            return false;
        }
    };
}
