package com.example.hellokotlin
/*
    [java에서 배열 만드는 방법이 2가지가 있었다]
    정수를 담을 수 있는 방 5개짜리 배열 만들기
    int[] nums={0,0,0,0,0};
    int[] nums=new int[5];
    String[] names={null,null,null,null,null,null};
    String[] names= new String[5];
 */

fun main(){
    // 0으로 초기화된 방 5개 짜리 Array 객체 만들기
    val num= arrayOf(0,0,0,0,0)
    val nums2=Array<Int>(5,{0})

    // 문자열을 담을 수 있는 null로 초기화 된 방 3개짜리 배열
    val names= arrayOf<String?>(null,null,null)
    val names2=Array<String?>(3,{null})
    val names3= Array<String?>(3){null}

    val msgs=Array<String>(100){
        "메세지 $it"
    }

    msgs.forEach {
        println(it);
    }
}