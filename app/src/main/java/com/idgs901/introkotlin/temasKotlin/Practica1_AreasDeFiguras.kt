package com.idgs901.introkotlin.temasKotlin

import kotlin.math.PI

import kotlin.math.*

fun main() {
    while (true) {
        println("\nCALCULAR ÁREAS")
        println("1. Circulo")
        println("2. Cuadrado")
        println("3. Triangulo")
        println("4. Pentagono")
        println("5. Salir")
        print("Elige opcion: ")

        when (readln()) {
            "1" -> {
                print("Radio del circulo: ")
                val r = readln().toDouble()
                println("Área: ${PI * r * r}")
            }
            "2" -> {
                print("Lado del cuadrado: ")
                val l = readln().toDouble()
                println("Área: ${l * l}")
            }
            "3" -> {
                print("Base del triángulo: ")
                val b = readln().toDouble()
                print("Altura del triángulo: ")
                val h = readln().toDouble()
                println("Área: ${b * h / 2}")
            }
            "4" -> {
                print("Lado del pentágono: ")
                val l = readln().toDouble()
                println("Área: ${(5 * l * l) / (4 * tan(PI / 5))}")
            }
            "5" -> {
                println("Adiós")
                return
            }
            else -> println("Opción incorrecta")
        }
    }
}