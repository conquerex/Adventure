package com.example.jongkook.chap03_output_permission;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mResult;
    final int READ_CONTACT_CODE = 0;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResult = (TextView)findViewById(R.id.textView);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("button1","button1 :::: button1");
                tryOutContact();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("button2","button2 :::: button2");
                mResult.setText("주소록");
            }
        });
    }

    void tryOutContact(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "허가된 상태", Toast.LENGTH_SHORT).show();
            // READ_CONTACTS 퍼미션이 있는지 조사
            // 있을 경우, outContact 메서드를 호출 안전하게 주소록 확인
            outContact();
            Log.i("tryOutContact","tryOutContact :::: outContact()");
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)){
                new AlertDialog.Builder(this)
                        .setMessage("읽기 퍼미션이 필요합니다. 허가해주세요.")
                        .setTitle("플리즈")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.READ_CONTACTS},
                                        READ_CONTACT_CODE);
                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // empty
                            }
                        }).show();
            } else {
                Toast.makeText(this, "허가된 상태가 아니어서 퍼미션 요청", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.READ_CONTACTS}, READ_CONTACT_CODE);
            }
            Log.i("tryOutContact","tryOutContact :::: requestPermissions");
        }
    }

    // 사용자 응답은 onRequestPermissionsResult 콜백으로 전달
    // 허가요청 팝업이 나타나야 함
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Toast.makeText(this, "onRequestPermissionsResult !!!", Toast.LENGTH_SHORT).show();
        switch (requestCode){
            case READ_CONTACT_CODE:
                // 아래 grantResults[0]가 '-1'이 나오는 문제 : PERMISSION_DENIED 상태
                // Manifest에 permission tag 추가해야 했음
                Toast.makeText(this, grantResults.length +" :: "+grantResults[0]+" :: "+PackageManager.PERMISSION_GRANTED,
                        Toast.LENGTH_SHORT).show();
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    outContact();
                    Toast.makeText(this, "사용자가 퍼미션을 허가함", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "사용자가 퍼미션을 거부함", Toast.LENGTH_SHORT).show();
                    // todo : 다른 대책을 찾거나 에러 처리한다.
                }
        }
    }

    void outContact(){
        // ContentResolver
        //  : ContentProvider 에 접근한 후 URI 주소만 안다면 어떤 정보라도 접근이 가능
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(
                ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int nameidx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        if(cursor.moveToNext()){
            mResult.setText(cursor.getString(nameidx));
            Log.i("outContact","outContact :::: nameidx");
        }else{
            mResult.setText("주소록이 비었음");
            Log.i("outContact","outContact :::: null");
        }
        cursor.close();
    }
}
