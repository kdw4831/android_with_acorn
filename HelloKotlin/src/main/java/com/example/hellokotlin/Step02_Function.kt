package com.example.hellokotlin

fun main(){
    /*
        in java => public void a(){}
        in kotlin => fun a(): Unit{} or fun a(){}
        코틀린에서 Unit은 원시 type 이라고 지칭하고 java의 void와 비슷한 역할을 한다.
     */

    //함수명() :리턴 type{ }
    fun a():Unit{
        println("a 함수 호출됨!")
    }
    // 이름 없는 함수를 만들어서 그 참조값을 변수에 담기
    var b = fun(){ }

    /*
        {함수의 type 정의하는 방법}

        (매개변수의 모양)-> 리턴 type
     */
    var c:()->Unit  = fun():Unit{} //함수의 type을 정의한 것 ()->Unit
    //String type을 전달 받아서 해당 문자열의 길이를 리턴하는 함수를  변수에 담아보세여
    //함수의 type을 정확히 명시해서
    var f:(String)->Int=fun(str:String):Int{
        return str.length
    }
    //f라는 변수에는 (String)->Int type의 함수만 담을 수 있다.
    //    f=10 // Int type은 대입되지 않는다.
    //    f="kim" //String type은 대입되지 않는다.
    //    f=fun(){}// ()->Unit type은 대입되지 않는다.
    f=fun(a:String):Int{ return 999}   //(String) -> Int type이기 때문에 대입된다.

    var test:(Int, String)->Int
    //test라는 변수에  값을 대입해 보세요
    test=fun(a:Int,b:String):Int{
        return 10
    }
}