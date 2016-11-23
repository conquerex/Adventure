package com.example.jongkook.chap03_output_customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView view = new MyView(this);
        //setContentView(R.layout.activity_main);
        setContentView(view);
    }

    // MyView라는 이름의 커스텀뷰
    class MyView extends View{

        // 생성자는 상속되지 않음
        // 부모가 디폴트 생성자를 제공하지 않는 한 직접 정의
        public MyView(Context context) {
            // 부모의 생성자만 호출하면 되기에 아래처럼 구현
            super(context);
        }

        public void onDraw(Canvas canvas){
            canvas.drawColor(Color.LTGRAY);
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            // 수치는 모두 픽셀 px 단위
            canvas.drawCircle(100,100,80,paint);

            // Bitmap 사용
            // 1. 리소스 객체를 얻기
            // :: 리소스 관리자 얻음
            Resources res = getResources();
            // 2. 인수로 리소스의 ID를 전달하면 해당 리소스를 리턴
            //    리소스 폴더에는 이미지 뿐만 아니라 색상 도형등의 여러가지 리소스가 포함되어 있음
            //    Bitmap 객체를 바로 읽는 것이 아니라 드로블의 루트 클래스인 Drawable의 서브클래스 타입을 읽어줌
            //    비트맵을 읽으면 BitmapDrawable 타입의 객체가 리턴 대입받기 위해 캐스팅 필요
            // :: 비트맵 드로블 읽음
            BitmapDrawable bd = (BitmapDrawable)res.getDrawable(R.drawable.future_2016_1);
            // 3. XML의 bitmap 엘리먼트로 정의되는 비트맵 리소스가 BitmapDrawable
            //    이 객체로부터 출력에 사용할 수 있는 비트맵을 얻으려면 getBitmap 메서드 호출
            // :: 비트맵 추출
            Bitmap bit = bd.getBitmap();

            // 위치 좌표 (10, 10)
            // canvas.drawBitmap(bit, 10,10,null);
            // src : null (전체 출력)
            canvas.drawBitmap(bit, null, new Rect(120,10,170,80),null);
            // src : Rect(30,30,70,80) (부분 출력)
            canvas.drawBitmap(bit, new Rect(30,30,70,80),new Rect(180,10,180+80,10+100),null);

            // Path 사용
            paint.setStyle(Paint.Style.STROKE);
            Path path = new Path();
            path.moveTo(40, 200);
            path.cubicTo(180,250,250,180,320,250);
            paint.setStrokeWidth(2);
            paint.setColor(Color.RED);
            canvas.drawPath(path, paint);

            // 곡선 패스 위에 텍스트 출력
            paint.setTextSize(40);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            canvas.drawTextOnPath("It is a test text", path, 0,0,paint);
        }
    }
}
