package com.example.hellokotlin

/*
    String과 String은 다른 type으로 취급된다.
    즉 type에 ?가 붙은 것과 안붙은 것은 다른 type이다.
    ? 가 안 붙으면 null이 불가능한 type
    ? 가 붙으면 null이 가능한 type
 */


fun main(){
    var a:String
    var b:String="kim"
    var c:String?= null

    //println(a.length) //초기화 되지 않았기 때문에 a는 사용 불가
    println("문자열의 길이: "+b.length)
    // c가 null 아닌 경우에만 length를 참조해라(null safe)
    println("문자열의 길이:" + c?.length)
    println("main 함수가 종료됩니다.")
}