package com.example.step01hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 버튼을 눌렀을 때 호출될 예정인 메소드 만들기
    public void clicked(View v){// 반드시 View type 매개 변수 1개를 선언해야 한다.
        Log.d("MainActivity","버튼을 눌렀네?");
    }
}