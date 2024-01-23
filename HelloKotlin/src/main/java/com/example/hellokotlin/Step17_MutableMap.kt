package com.example.hellokotlin

fun main(){
    //수정가능한 Map
    val mem:MutableMap<String,Any> = mutableMapOf<String, Any>()
    //필요한 만큼 데이터를 저장할 수 있다.
//    mem.put("num",1)
//    mem.put("name","김구라")
//    mem.put("isMan",true)
//
//    //동일한 키 값으로 기존의 value를 덮어쓰기 할 수 있다.
//    mem.put("name", "이정호")

      //필요한 만큼 데이터를 저장할 수 있다.
      mem["num"]=1
      mem["name"]="김구라"
      mem["isMan"]=true
      //동일한 key 값으로 기존의 value를 덮어쓰기 할 수 있다.
      mem["name"]="이정호"

      val num=mem["num"] as Int
      val name=mem["name"] as String
      val isMan=mem["isMan"] as Boolean
}