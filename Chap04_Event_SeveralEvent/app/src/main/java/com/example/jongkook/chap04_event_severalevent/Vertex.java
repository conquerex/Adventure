package com.example.jongkook.chap04_event_severalevent;

/**
 * Created by jongkook on 2017. 1. 25..
 */

// Vertex 클래스
// 정점 하나에 대한 정보를 가지는 클래스
public class Vertex {
    float x, y;
    // draw : 선을 그을 것인지 이동만 할 것인지.
    boolean draw;
    public Vertex(float ax, float ay, boolean ad) {
        x = ax;
        y = ay;
        draw = ad;
    }
}
