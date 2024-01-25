package com.example.step08httprequest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.step08httprequest.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    //다른 스레드에서 메세지를 받아서 UI를 업데이트 할 Handler 객체
    Handler handler= new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //여기는 메인스레드(UI 스레드)이다
            //Message 객체에 담겨온 문자열을 얻어내서
            String data=(String)msg.obj;
            //출력한다
            binding.editText.setText(data);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view binding을 이용해서 레이아웃 구성하기
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //요청버튼을 눌렀을 때 리스너 동작할 리스너 등록
        binding.requestBtn.setOnClickListener(v->{
            //입력한 url 주소를 읽어와서
            String url=binding.inputUrl.getText().toString();
            //요청을 한다.
            makeHttpRequest(url);
        });
    }

    public  void makeHttpRequest(String url){
        //새로운 스레드에서 요청을 보내도록한다.
        new RequestThread(url).start();

    }
    class RequestThread extends Thread{
        String url;
        //생성자
        public RequestThread(String url){
            this.url=url;
        }
        public void run(){
            //문자열 누적할 객체
            StringBuilder builder=new StringBuilder();

            try{

                //요청 url을 생성자의 인자로 전달하면서 URL 객체를 생성한다
                URL url= new URL(this.url);
                //URLConnection 객체를 원래 type(자식 type)으로 casting해서 받느다.
                HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                if(conn != null){
                    conn.setConnectTimeout(20000); //응답을 기다리는 최대 대기 시간
                    conn.setRequestMethod("GET"); // 요청 메소드 설정(Default 는 GET)
                    conn.setUseCaches(false); //캐쉬 사용 여부
                    //응답 코드를 읽어온다.
                    int responseCode=conn.getResponseCode();
                    if(responseCode==HttpURLConnection.HTTP_OK){ //정상 응답이라면(200)
                        //문자열을 읽어들일 수 있는 객체의 참조값 얻어오기
                        BufferedReader br=
                                new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        //반복문 돌면서
                        while(true){
                            //문자열을 한줄씩 읽어 들인다.
                            String line= br.readLine();
                            if(line==null)break;
                            //StringBuilder 객체에 누적 시키기
                            builder.append(line);
                        }
                    }
                }
            }catch (Exception e){
                Log.e("MainActivity",e.getMessage());
            }//try-catch
            //UI 스레드(Main Thread)가  아닌 곳에서 UI를 업데이트하는 것은 위험하다
            //binding.editText.setText(builder.toString());
            //Message 객체에 응답된 문자열을 담아서
            Message msg= new Message();
            msg.what=0;
            //Object를 담을 수 있는 공간에 String type을 담아서
            msg.obj=builder.toString();
            //Handler 객체에 보낸다
            handler.sendMessage(msg);
        }//run()
    }//class RequestThread

}