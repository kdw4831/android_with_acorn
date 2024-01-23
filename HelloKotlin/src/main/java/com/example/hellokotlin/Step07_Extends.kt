package com.example.hellokotlin

// 클래스 상속
/*
    클래스 선언시 기본값은 상속을 받지 못하게 되어 있다.
    마치 java에서 final class Phone{ } 처럼..
    상속을 받을 수 있게 하려면 open 이라는 예약어를 붙여준다.
 */

open class Phone{
    fun call(){
        println("전화를 걸어요!")
    }
}

//요게 extends phone 이런 개념
open class HandPhone : Phone(){
    fun mobileCall(){
        println("이동중에 전화를 걸어요!")
    }
    //재정의 가능한 메소드로 만들려면 open 예약어를 붙여야한다.
    open fun takePicture(){
        println("100만 화소의 사진을 찍어요!")
    }
}

class SmartPhone :HandPhone(){
    fun doInternet(){
        println("인터넷을 해요!")
    }
    //override라는 예약어를 이용해서 open된 메소드를 오버라이드 할 수가 있다.
    override fun takePicture() {
        // 필요시 부모의 메소드를 호출할 수도 있다.(java와 동일)
        super.takePicture()
        println("1000만 화소의 사진을 찍어요!")
    }
}

fun main(){
    val p1=Phone()
    val p2=HandPhone()
    //Phone 클래스를 상속받은 클래스로 생성한 객체이므로 3개의 메소드 모두를 사용할 수 있다.
    p2.call()
    p2.mobileCall()
    p2.takePicture()// 100만화소의 사진

    val p3=SmartPhone()
    p3.doInternet()
    p3.takePicture()//1000만 화소의 사진(메소드 오버라이드)
}