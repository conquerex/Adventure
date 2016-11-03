package com.example.jongkook.chap01_basecamp_rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        // Observable : 데이터를 제공하는 생산자
        Observable<String> observable =
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Base camp. arrive.");
                        Log.i("test","--------------------");
                        subscriber.onCompleted();
                    }
                });

        // Subscriber : 스트림의 데이터의 유형별로 대칭되는 서브스크라이버의 인터페이스가 대응하는 것
        observable.subscribe(new Subscriber<String>() {
            @Override // onCompleted - 스트림의 종료.
            public void onCompleted() {
                Log.d("onCompleted", "Complete!!!");
            }

            @Override // onError - 에러 신호를 전달한다
            public void onError(Throwable e) {
                Log.e("onError", "err : "+e.getMessage());
            }

            @Override // onNext - 새로운 데이터를 전달한다.
            public void onNext(String s) {
                textView.setText(s+" ---");
            }
        });
    }
}
