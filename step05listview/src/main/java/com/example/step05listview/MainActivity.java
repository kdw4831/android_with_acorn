package com.example.step05listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener,
    AdapterView.OnItemLongClickListener{
    ArrayAdapter<String> adapter;
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sample 데이터
        names= new ArrayList<>();
        names.add("김구라");
        names.add("해골");
        names.add("원숭이");
        for(int i=0; i<5; i++){
            names.add("아무게"+i);
        }
        //ListView에 연결할 아답타
        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,names);
        //ListView의 참조값 얻어오기
        ListView listView=findViewById(R.id.listView);
        //ListView에 아답타 연결하기
        listView.setAdapter(adapter);
        //버튼에 리스너 등록하기
        Button addBtn= findViewById(R.id.addBtn);
        addBtn.setOnClickListener(v->{
            //1. EditText 에 입력한 문자열을 읽어와서
            EditText inputName= findViewById(R.id.inputName);
            String name=inputName.getText().toString();
            //2. names(모델)에 추가하고
            names.add(name);
            //3. 아답타에 names(모델)이 변경되었다고 알린다.
            adapter.notifyDataSetChanged();
            //4. EditText에 입력한 내용 지우기
            inputName.setText("");
            //5. 마지막 위치까지 부드럽게 스크롤하기
            int position= adapter.getCount(); //전체 아이템 갯수
            listView.smoothScrollToPosition(position);
        });
        //listView에 AdapterView.ItemClickListener 등록하기
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
            parent => Listview
            view   => cell view (TextView)
            position =>클릭한 cell의 인덱스
            id=> 클릭한 cell의 아이템 아이디(PK)가 있다면 아이디가 전달된다.(없으면 index가 전달됨)
         */
        Log.d("MainActivity","position:"+position);
        //클릭한 cell에 출력된 이름
        String name=names.get(position);
        //Toast 메세지로 출력해보기
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("삭제할까요?")
                .setPositiveButton("네", (dialog, which) -> {
                    //Long Click 된 cell의 index => position
                    names.remove(position);
                    //UI 업데이트
                    adapter.notifyDataSetChanged();

                })
                .setNegativeButton("아니요", null)
                .create()
                .show();
        return false;
    }
}