package com.idgs901.introkotlin.temasKotlin

import kotlin.math.*

// Clase principal que maneja la lógica de la calculadora
class CalculadoraAreas {
    companion object {
        // Constante PI
        private const val PI = Math.PI

        // Función para mostrar el menú
        fun mostrarMenu() {
            println("\nCALCULAR ÁREAS")
            println("1. Círculo")
            println("2. Cuadrado")
            println("3. Triángulo")
            println("4. Pentágono")
            println("5. Salir")
            print("Elige opción: ")
        }

        // Función para calcular área del círculo
        fun calcularAreaCirculo(radio: Double): Double {
            return PI * radio * radio
        }

        // Función para calcular área del cuadrado
        fun calcularAreaCuadrado(lado: Double): Double {
            return lado * lado
        }

        // Función para calcular área del triángulo
        fun calcularAreaTriangulo(base: Double, altura: Double): Double {
            return base * altura / 2
        }

        // Función para calcular área del pentágono regular
        fun calcularAreaPentagono(lado: Double): Double {
            return (5 * lado * lado) / (4 * tan(PI / 5))
        }

        // Función para leer un valor double con mensaje personalizado
        fun leerValor(mensaje: String): Double {
            print(mensaje)
            return readln().toDouble()
        }
    }
}

// Función principal
fun main() {
    val calculadora = CalculadoraAreas()

    while (true) {
        CalculadoraAreas.mostrarMenu()

        when (readln()) {
            "1" -> {
                val radio = CalculadoraAreas.leerValor("Radio del círculo: ")
                val area = CalculadoraAreas.calcularAreaCirculo(radio)
                println("Área: $area")
            }
            "2" -> {
                val lado = CalculadoraAreas.leerValor("Lado del cuadrado: ")
                val area = CalculadoraAreas.calcularAreaCuadrado(lado)
                println("Área: $area")
            }
            "3" -> {
                val base = CalculadoraAreas.leerValor("Base del triángulo: ")
                val altura = CalculadoraAreas.leerValor("Altura del triángulo: ")
                val area = CalculadoraAreas.calcularAreaTriangulo(base, altura)
                println("Área: $area")
            }
            "4" -> {
                val lado = CalculadoraAreas.leerValor("Lado del pentágono: ")
                val area = CalculadoraAreas.calcularAreaPentagono(lado)
                println("Área: $area")
            }
            "5" -> {
                println("Adiós")
                return
            }
            else -> println("Opción incorrecta")
        }
    }
}