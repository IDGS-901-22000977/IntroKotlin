package com.idgs901.introkotlin.temasKotlin

class usuarios2(val id:Int, val nombre:String){
    val materia:String=""
    fun hola(){
        println("Hola")
    }
}

class usuarios() {
    val materia: String = ""
}

fun main(){
    val alumno = usuarios()
    val alumno2 = usuarios2(1,"Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
    alumno2.hola()
}

