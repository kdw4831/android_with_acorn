package com.example.hellokotlin


fun main(){
    //ReadOnly Map type 객체 만들기
   val mem:Map<String,Any> =mapOf<String,Any>("num" to 1, "name" to "김구라", "isMan" to true)

//   val num:Any? = mem.get("num")
//   val name:Any? = mem.get("name")
//   val isMan:Any? = mem.get("isMan")


// 아래와 같이 참조 할 수도 있다.
//   val num = mem["num"]
//   val isMan = mem["isMan"]
//   val name = mem["name"]

    //casting까지 동시에 하기
    val num  = mem.get("num") as Int //as 캐스팅할 타입
    val name = mem.get("name") as String
    val isMan = mem.get("isMan") as Boolean
}