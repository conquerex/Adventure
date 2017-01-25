package com.example.jongkook.chap04_event_severalevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Myview view;
    private Myview2 view2;
    ArrayList<Vertex> arVertex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new Myview(this);
        setContentView(view);
        view.arVertex = new ArrayList<Vertex>();
    }
}
