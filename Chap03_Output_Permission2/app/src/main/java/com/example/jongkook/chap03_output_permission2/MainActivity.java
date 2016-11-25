package com.example.jongkook.chap03_output_permission2;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResult = (TextView)findViewById(R.id.result);
    }

    TextView mResult;
    final int READ_CONTACT_CODE = 0;

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnread:
                // 주소록 읽기 버튼 클릭
                tryOutContact();
                break;
            case R.id.btnreset:
                // 초기화 버튼 클릭
                mResult.setText("주소록");
                break;
        }
    }

    void tryOutContact() {
        // 퍼미션 체크 로직
        // 1. 퍼미션이 있는가
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) ==
                PackageManager.PERMISSION_GRANTED) {
            // 매니페스트에 권한이 등록되어 있는 상태
            Toast.makeText(this, "허가된 상태", Toast.LENGTH_SHORT).show();
            outContact();
        } else {
            // 2. 퍼미션이 없을 시
            // shouldShowRequestPermissionRationale
            // 설명을 출력할 시점인지 조사한 후 대화상자로 이 퍼미션이 필요한 이유를 상세히 설명
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
                new AlertDialog.Builder(this)
                        .setMessage("이 프로그램이 원활하게 동작하기 위해서는 " +
                                "주소록 읽기 퍼미션이 꼭 필요합니다." +
                                "퍼미션을 허가해 주세요.")
                        .setTitle("제발~~")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.READ_CONTACTS},
                                        READ_CONTACT_CODE);
                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        })
                        .show();
            } else {
                // 3. 퍼미션을 유저가 허가 하지 않은 상태
                // onRequestPermissionsResult를 부르게 된다
                Toast.makeText(this, "허가된 상태가 아니어서 퍼미션 요청",
                        Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        READ_CONTACT_CODE);
            }
        }
    }

    // 4. 퍼미션을 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode) {
            case READ_CONTACT_CODE:
                // 퍼미션을 허가했을 경우
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "사용자가 퍼미션 허가함",
                            Toast.LENGTH_SHORT).show();
                    outContact();
                } else {
                    // 퍼미션을 허가하지 않았을 경우
                    Toast.makeText(this, "사용자가 퍼미션 거부함",
                            Toast.LENGTH_SHORT).show();
                    // todo : 다른 대책을 찾거나 에러 처리한다.
                }
        }
    }

    // 셀제 이벤트
    void outContact() {
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(
                ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int nameidx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        // 주소록 내용 확인
        if (cursor.moveToNext()) {
            mResult.setText(cursor.getString(nameidx));
        } else {
            mResult.setText("주소록이 비어 있습니다.");
        }
        cursor.close();
    }
}
