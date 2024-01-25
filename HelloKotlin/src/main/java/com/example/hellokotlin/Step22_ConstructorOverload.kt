package com.example.hellokotlin

// 생성자 여러개 만들기

class MyData{
    constructor()

    constructor(num:Int)

    constructor(num:Int,name:String)

}

class YourData{
    //디폴트 값을 넘겨줄 수 있다 , 즉 빈생성자여도 0, ""이 들어가는 것
    //매개 변수에 기본값을 설정하면 다중정의된 효과를 얻어낼 수 있다.
    constructor(num:Int=0,name:String="")
}
class YourData2{
    //디폴트 값을 넘겨줄 수 있다 , 즉 빈생성자여도 0, ""이 들어가는 것
    //매개 변수에 기본값을 설정하면 다중정의된 효과를 얻어낼 수 있다.
    @JvmOverloads constructor(num:Int=0,name:String="")
}

//data 클래스는 setter ,getter 메소드를 자동으로만들어준다.
data class OurData @JvmOverloads constructor(var num:Int=0, var name:String=""){

}

fun main(){
    // 다양한 모양으로 객체를 생성할 수 있다.
    val a=MyData()
    val b=MyData(1)
    val c=MyData(1,"김구라")

    // YourData도 다양한 모양으로 객체를 생성할 수가 있다.
    val d=YourData()
    val e=YourData(2)
    val f=YourData(2,"해골")

    val g= OurData()
    val h= OurData(3)
    val i= OurData(3,"원숭이")

}
