package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String msg="";
    EditText inputNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNum=findViewById(R.id.inputNum);


        Button testBtn=findViewById(R.id.testBtn);

        testBtn.setOnClickListener(v -> {
            int num= Integer.parseInt(inputNum.getText().toString());
            if(num % 2==0){

                msg="짝수입니다.";
            }else{
                msg="홀수입니다.";

            }
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

        });


    }

}