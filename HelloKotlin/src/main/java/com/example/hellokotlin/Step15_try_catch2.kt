package com.example.hellokotlin

import java.lang.NumberFormatException

fun main(){
    var str="1000"
    var str2="천"

    //아래와 같은 try~catch도 가능하다
    var result=try{
        //예외가 발생하지 않은 경우 대입될값
        Integer.parseInt(str)
    }catch (nfe:NumberFormatException){
        0 //예외가 발생할 경우 대입될 값
    }

    println("result:${result}")
}