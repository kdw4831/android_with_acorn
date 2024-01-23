package com.example.step04example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText first,second;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText 객체의 참조값을 얻어와서 필드에 저장
        first= findViewById(R.id.first);
        second=findViewById(R.id.second);
        //TextView의 참조값을 얻어와서 필드에 저장
        result= findViewById(R.id.result);
        //버튼에 클릭 리스너 등록하기
        Button plusBtn= findViewById(R.id.plusBtn);
        Button minusBtn= findViewById(R.id.minusBtn);
        //MainActivity의 참조값을 전달해서 리스너를 등록한다.
        //MainActivity는 implements View.OnClickListener 했기 때문에 등록이 가능하다.
        plusBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        /*
        plusBtn.setOnClickListener(v -> {
            int firstValue= Integer.parseInt(first.getText().toString());
            int secondValue=Integer.parseInt(second.getText().toString());
            int resultValue= firstValue+secondValue;
            result.setText(Integer.toString(resultValue));
        });

        minusBtn.setOnClickListener(v -> {
            int firstValue= Integer.parseInt(first.getText().toString());
            int secondValue=Integer.parseInt(second.getText().toString());
            int resultValue= firstValue-secondValue;
            result.setText(Integer.toString(resultValue));
        });*/
    }
    /*
        MainActivity를 클릭 리스너로 등록한 View(Button)에 클릭이벤트가
        발생하면 호출되는 메소드
     */
    @Override
    public void onClick(View view) {
        //입력한 내용을 읽어와서 산술연산이 가능한 숫자로 변경한다.
        double num1=Double.parseDouble(first.getText().toString());
        double num2=Double.parseDouble(second.getText().toString());
        double result=0;
        // View type view에는 이벤트가 발생한 Button의 참조값이 전달된다.
        // 눌러진 버튼의 아이디값을 읽어온다(정수값)
        int id=view.getId();
        if(id==R.id.plusBtn){
            result= num1+num2;
        }else if(id==R.id.minusBtn){
            result= num1-num2;
        }
        //계산 결과를 문자열(String)로 변환해서 TextView에 출력하기
        String strResult= String.valueOf(result);
        //TextView에 출력하기
        this.result.setText(strResult);
    }
}