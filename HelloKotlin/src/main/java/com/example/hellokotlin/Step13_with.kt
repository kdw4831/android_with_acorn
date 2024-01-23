package com.example.hellokotlin

fun main(){
    class Member{
        var num:Int? =null
        var name:String?=null
        var isMan:Boolean?=null
        fun showInfo(){
            println("${this.num},${this.name},${this.isMan}")

        }
    }

    val m1=Member();

    m1.num=1
    m1.name="김구라"
    m1.isMan=true
    m1.showInfo()

    val m2=Member()
    val a:Unit=with(m2){
        num=2
        name="해골"
        isMan=false
        showInfo()
    }

    val m3=Member()
    val result:String=with(m3){
        num=3
        name="원숭이"
        isMan=true
        //가장 마지막 번째 line이 리턴 값이다.
        "${this.num},${this.name},${this.isMan} 입니다"//요게 리턴값이다 그래서 문자열을 리턴한다.
    }
}