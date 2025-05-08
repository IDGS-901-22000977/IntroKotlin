package com.idgs901.introkotlin.temasKotlin

import kotlin.math.sqrt

fun main() {
    println("\nRESOLUCION DE ECUACION CUADRATICA")
    println("Forma general: ax^2 + bx + c = 0")

    print("Ingresa el valor de a: ")
    val a = readln().toDouble()

    print("Ingresa el valor de b: ")
    val b = readln().toDouble()

    print("Ingresa el valor de c: ")
    val c = readln().toDouble()

    val form = b * b - 4 * a * c

    when {
        form > 0 -> {
            val x1 = (-b + sqrt(form)) / (2 * a)
            val x2 = (-b - sqrt(form)) / (2 * a)
            println("Soluciones reales diferentes:")
            println("x1 = $x1")
            println("x2 = $x2")
        }
        form == 0.0 -> {
            val x = -b / (2 * a)
            println("Solución real única:")
            println("x = $x")
        }
        else -> {
            println("Soluciones complejas:")
            val primer = -b / (2 * a)
            val segu = sqrt(-form) / (2 * a)
            println("x1 = ${primer} + ${segu}i")
            println("x2 = ${primer} - ${segu}i")
        }
    }
}