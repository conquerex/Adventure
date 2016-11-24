package com.example.jongkook.chap03_output_permission;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
                tryOutContact();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mResult.setText("주소록");
            }
        });
    }

    void tryOutContact(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED){
            outContact();
            Log.i("tryOutContact","tryOutContact :::: outContact()");
        }else{
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_CONTACTS}, READ_CONTACT_CODE);
            Log.i("tryOutContact","tryOutContact :::: requestPermissions");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case READ_CONTACT_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    outContact();
                    Toast.makeText(this, "Call outContact !!!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    void outContact(){
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(
                ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        int nameidx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        if(cursor.moveToNext()){
            mResult.setText(cursor.getString(nameidx));
        }else{
            mResult.setText("주소록이 비었음");
        }
        cursor.close();

    }


}
