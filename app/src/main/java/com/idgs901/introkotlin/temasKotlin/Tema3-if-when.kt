package com.idgs901.introkotlin.temasKotlin

fun main(){

    val d:Int
    val e=true

    if(e){
        d=1
    }else{
        d=2
    }

    println(d)
    val numero=if(e)1 else 2
    println(numero)

    print("Ingrese el sueldo del empleado:")
    val sueldo = readln().toDouble()
    if(sueldo > 3000){
        println("Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }


//when

    val objeto:Any="Hola"
    when(objeto){
        "1" -> println("Es un uno")
        "Hola" -> println("Es un saludo")
        is String -> println("Es un String")
        else -> println("No se que es")
    }

//Range
    1..4
    4 downTo 1
    1..10 step 2
    'a'..'g'
    'z' downTo 'a' step 2
}

