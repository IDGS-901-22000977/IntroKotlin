package com.idgs901.introkotlin.temasKotlin

fun main(){

    for(number in 1..5){
        println(number)
    }

    val nombres= listOf("Ronald","Mario","Veronica")
    for(nombre in nombres){
        println(nombre)
    }


//while

    var x =0
    while (x <5) {
        println(x)
        x++
    }


    do{
        println(x)
        x++
    }while (x < 5)


}

