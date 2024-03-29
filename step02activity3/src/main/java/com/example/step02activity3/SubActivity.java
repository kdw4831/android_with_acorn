package com.example.step02activity3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Log.e("SubActivity", "onCreate()");

//        Button moveBtn=findViewById(R.id.moveBtn);
//        moveBtn.setOnClickListener(v->{
//            Intent intent =new Intent(this, SubActivity.class);
//            startActivity(intent);
//        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SubActivity", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("SubActivity", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SubActivity", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SubActivity", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SubActivity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SubActivity", "onDestroy()");
    }
}