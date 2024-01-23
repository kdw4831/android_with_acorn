package com.example.hellokotlin

fun main(){
    val nums= mutableListOf(10,-5,-6,1,4,-7,-8,20,30,-15,-1,-13)

    //for 문을 활용해서 nums List에서 음수를 모드 제거해보세요
    /*
    for(i in nums.size-1 downTo 0){
        if(nums[i]<0){
            //nums에서 i 번째 인덱스 삭제
            nums.removeAt(i)
        }
    }
    */
    // 삭제하면 땡겨진다. 그래서 역순으로 삭제를 해야한다.
    for(i in nums.indices.reversed()){
        if(nums[i]<0){

            nums.removeAt(i)
        }
    }


    // 삭제후에 음수가 모두 삭제 되었는지 순서대로 출력해 보세요
    for(item in nums){
        println(item)
    }
    println("------")
    //삭제된 배열을 얻어내고 싶다면 .filter() 함수를 사용하면된다.
    val nums2= mutableListOf(10,-5,-6,1,4,-7,-8,20,30,-15,-1,-13)
    // result는 음수가 제거된 새로운 배열이다.
    val result= nums2.filter (fun(item):Boolean{
        return item>=0
    })

    val result2=nums2.filter ({item->
        item>=0
    })

    val result3=nums2.filter {item->
        item>=0
    }

    //람다식의 매개변수가 1개인 경우에는 매개변수를 선언하지 않고 it으로 매개변수에 전달된 값을 가리킬수 있다.
    val result4=nums2.filter { it>=0 }

    for(item in result){
        println(item)
    }
}