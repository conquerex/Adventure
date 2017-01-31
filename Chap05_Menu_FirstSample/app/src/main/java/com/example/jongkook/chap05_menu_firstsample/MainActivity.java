package com.example.jongkook.chap05_menu_firstsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView MyText = new TextView(this);
        MyText.setText("메뉴 키를 누르세요");
        setContentView(MyText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem item = menu.add(0,1,0,"짜장");
        item.setIcon(R.mipmap.ic_launcher);
        item.setAlphabeticShortcut('a');

        menu.add(0,2,0,"짬뽕").setIcon(R.mipmap.ic_launcher);
        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "짜장은 달콤", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "짬뽕은 매콤", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "우동은 얼큰", Toast.LENGTH_SHORT).show();
                return true;
            case 4:
                Toast.makeText(this, "만두는 고소", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
