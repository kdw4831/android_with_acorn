package com.example.step06customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
//BaseAdapter 추상 클래스를 상속 받아서 만든다.

public class CountryAdapter extends BaseAdapter { //listview에 연결해서 만들예정
    //필드
    Context context;
    int layoutRes;
    List<CountryDto> list;

    //생성자(컨텍스트 , cell의 layout 리소스 아이디, 모델)
    public CountryAdapter(Context context, int layoutRes, List<CountryDto> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
    }

    @Override
    public int getCount() {
        //List의 size를 리턴하면 된다.
        return list.size();
    }

    // i번째 인덱스의 아이템 반환
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // i번째 인덱스의 아이템 아이디(PK)
    @Override
    public long getItemId(int i) {
        // 없으면 인덱스를 리턴
        return 1;
    }

    // i 번째  cell view를 만들어서 리턴해 주어야한다.
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.e("CountryAdapter","getView() 호출됨 position:"+i);
        if(view==null){
            Log.d("CountryAdapter","view가 null이여서 cell view를 새로 만듭니다.");
            //레이아웃 xml 문서를 전개해서 View 객체를 새로 만든다.
            LayoutInflater inflater=LayoutInflater.from(context);
            view = inflater.inflate(layoutRes,viewGroup,false);
        }
        // i에 해당하는 CountryDto 객체
        CountryDto dto= list.get(i);
        //View 객체 안에 있는 ImageView, TextView의 참조값을 얻어온다.
        ImageView imageView= view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textName);
        //ImageView, TextView에 정보를 출력한다.
        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getName());
        //i 번째 인덱스에 해당하는 View를 리턴해준다.
        return view;
    }
}
