package com.example.hellokotlin

fun main(){
    val names= listOf<String>( "김구라", "해골", "원숭이")
    val nums = listOf<Int>(10,20,30)
    //names List의 0번 index 참조하는 방법1
    val a=names.get(0)
    //names List의 0번 index 참조하는 방법2
    val b=names[0]
    //names의 item 갯수 참조
    val c=names.size
    //names의 마지막 인덱스 참조
    val d=names.lastIndex
    //List의 모든 item을 순회 하면서 참조
    names.forEach{
        println(it) // it 일는 키워드로 각각의 아이템을 가리킬 수 있다.
    }
    //인덱스가 같이 필요하다면
    for(i in names.indices){
        val tmp=names.get(i)
        println("${i} 번째 인덱스:${tmp}")
    }
    //역순으로 순회하기
    for(i in names.lastIndex downTo 0){
        val tmp=names.get(i)
        println("${i} 번째 인덱스 : ${tmp}")
    }
}