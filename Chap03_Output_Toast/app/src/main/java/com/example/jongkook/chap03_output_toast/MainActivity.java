package com.example.jongkook.chap03_output_toast;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Toast를 위한 변수
    Toast toast = null;
    int count;
    String str;

    // 비프음을 위한 변수
    SoundPool pool;
    int ddok;
    AudioManager manager;

    // 진동을 위한 변수
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Soundpool : 음원 파일을 미리 읽어 둔 후 필요할 때 재생
        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        ddok = pool.load(this, R.raw.start_so_long_trip, 0);
        // AudioPool : 볼륨 벨모드 등 조정 클래스
        //              별도 리소스 없이 시스템이 정의해 놓은 소리를 낼 수 있다
        manager = (AudioManager)getSystemService(AUDIO_SERVICE);

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        findViewById(R.id.button).setOnClickListener(onClickListener);
        findViewById(R.id.button2).setOnClickListener(onClickListener);
        findViewById(R.id.button3).setOnClickListener(onClickListener);
        findViewById(R.id.button4).setOnClickListener(onClickListener);
        findViewById(R.id.button5).setOnClickListener(onClickListener);

    }

    // 진동을 시작하면 액티비티 종료해도 계속 진동이 진행
    // 끝내기 전 반드시 중지 시켜야 함
    @Override
    protected void onDestroy() {
        super.onDestroy();
        vibrator.cancel();
    }

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button:
                    pool.play(ddok, 1,1,0,0,1);
                    vibrator.vibrate(500);
                    break;
                case R.id.button2:
                    // manager.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
                    // manager.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                    manager.playSoundEffect(AudioManager.FX_KEY_CLICK);
                    // 진동 패턴 넣기
                    vibrator.vibrate(new long[]{100,50,200,50},0);
                    break;
                case R.id.button3:
                    str = "Count = " +count++;
                    if(toast != null){
                        toast.cancel();
                    }
                    // makeText가 Toast 자체를 리턴
                    toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    toast.show();
                    vibrator.cancel();
                    break;
                // 토스트 자체가 아닌 텍스트만 카운트 올리
                case R.id.button4:
                    str = "Count = " +count++;
                    if(toast == null){
                        toast = Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT);
                    }else{
                        toast.setText(str);
                    }
                    toast.show();
                    break;
                // 토스트에 레이아웃으로 띄우기
                case R.id.button5:
                    LinearLayout linearLayout =
                            (LinearLayout)View.inflate(MainActivity.this, R.layout.toastshow, null);
                    Toast toast2 = new Toast(MainActivity.this);
                    toast2.setView(linearLayout);
                    toast2.show();
                    break;
            }
        }
    };
}
