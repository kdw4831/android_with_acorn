package com.example.hellokotlin

/*
    kotlin에서 배열(List)과 반복문
 */

fun main(){
    //수정불가능한 List (read only)
    val names= listOf<String>("kim", "lee", "park")
    //type 추론이 가능하기 때문에 상수의 type, List의 제네릭 type 모두 생략 가능
    val animals=listOf("dog","cat","elephant")
    //listOf() 안에 있는 데이터가 추론 가능하기 때문에 listOf의 Generic 도 생략 가능
    val nums= listOf(10,20,30)


    //배열 참조
    println(names[0])
    println(names[1])
    println(names[2])
    println("---------")
    println(names.get(0))
    println(names.get(1))
    println(names.get(2))

    // readonly 이기 때문에 수정 불가
    //names[0]="김구라" 요게 안된다.

    val result=names.indices

    //반복문
    for(i in names.indices){
        println("i")
    }
    println("-------")
    for(i in names.indices){
        println("$i : ${names[i]}")
    }
    println("-------")
    for(item in names){
        println(item)
    }
    println("-------")    // names.forEach() 함수가 있어 함수에 함수를 전달해야한다.
    names.forEach(fun(item){ //fun(){} 전달한 함수에는 값이 전달되는데
        println(item)     // 전달되는 값을 받을 매개 변수를 선언해야한다.
    })
    println("-------")
    names.forEach{
        println(it)
    }

}