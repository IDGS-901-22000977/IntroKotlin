package com.idgs901.introkotlin.temasKotlin


fun main() {
    var numero: Int

    do {
        println("Ingresa un número (0 para salir):")
        numero = readln().toInt()

        if (numero < 0) {
            println("Por favor, ingresa un número positivo o 0 para salir.")
        } else if (numero > 0) {
            var fila = 1
            do {
                var columna = 1
                do {
                    print("*")
                    columna++
                } while (columna <= fila)

                println()
                fila++
            } while (fila <= numero)
        }

    } while (numero != 0)

    println("Terminando....")
}