package com.example.hellokotlin

import java.util.Scanner

fun main(){
    var scan= Scanner(System.`in`)
    println("점수를 입력해주세요: ")
    val jumsu=scan.nextInt()
    when(jumsu){
        in 90..100 ->println("90에서 100사이 입니다.")
        in 80 ..90 -> println("80에서 90사이 입니다.")
        else -> println("80이하 입니다.")
    }


    println("----------")
    when{
        jumsu >=90 -> println("점수는 90점 이상입니다.")
        jumsu >=80 -> println("점수는 80점 이상입니다.")
        else-> println("점수는 80이하입니다.")
    }

    when(jumsu){
        in 90 ..100-> println("A학점")
        in 80 until 90-> println("B학점")
        in 70 until 80-> println("C학점")
        else -> println("ABC이외의 학점")
    }
}