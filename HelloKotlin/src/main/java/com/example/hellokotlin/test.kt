package com.example.hellokotlin
open class RTC

// class Web : RTC() {
//
//     const val brand = "Google"
//
//     fun run() {
//         println("실행")
//     }
//}


class Web : RTC() {

    companion object {
        const val brand = "Google"
    }
    fun run() {
        println("실행")
    }

}