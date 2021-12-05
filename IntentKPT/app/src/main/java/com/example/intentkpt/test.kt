package com.example.intentkpt

class Haha(a:String){
    init {
        println(a)
    }
    var max:Int = 0
    get() = field
    set(value){
        field=value
    }
}
fun main(){
    var b = Haha("")
    b.max=7
    println(b.max)
}