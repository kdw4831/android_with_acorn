package com.example.hellokotlin

//추상 클래스 => abstract 예약어를 이용해서 만든다.
abstract  class  Weapon{
    fun move(){
        println("이동합니다.")
    }
    //추상 메소드 역시 abstract 예약어를 이용해서 만든다.
    abstract  fun attack()
}

// 추상 클래스도 일반 클래스를 상속받는 문법과 같다
class MyWeapon : Weapon(){
    //추상메소드 오버라이드가 강제된다.
    override fun attack() {
        println("무언가를 공격해요!")
    }
}

fun main(){
    val w1:Weapon= MyWeapon()
    w1.move()
    w1.attack()

    //따로 클래스를 정의하지 않고 object 키워드를 이용해서 Weapon type 의 참조값 얻어내기
    val w2:Weapon = object  :Weapon(){
        override fun attack() {
            println("공중 공격을 해요!")
        }
    }

    w2.move()
    w2.attack()

    //다형성 확인
    val w3:MyWeapon =MyWeapon()
    val w4:Weapon= w3
    val w5:Any=w3 // Any type은 java에서 Object type에 해당되는 type이다.
}