package com.idgs901.introkotlin.ejemplo1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs901.introkotlin.R

class SumaActivity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioGroupOperaciones: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)

        // Inicializar vistas
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioGroupOperaciones = findViewById(R.id.radioGroupOperaciones)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {
        val num1 = et1.text.toString().toDoubleOrNull() ?: 0.0
        val num2 = et2.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = 0.0

        // Obtener el RadioButton seleccionado
        val selectedId = radioGroupOperaciones.checkedRadioButtonId
        val radioButton: RadioButton = findViewById(selectedId)

        when (radioButton.id) {
            R.id.radioSuma -> resultado = num1 + num2
            R.id.radioResta -> resultado = num1 - num2
            R.id.radioMultiplicacion -> resultado = num1 * num2
            R.id.radioDivision -> {
                if (num2 != 0.0) {
                    resultado = num1 / num2
                } else {
                    tv1.text = "Error: División por cero"
                    return
                }
            }
        }

        tv1.text = "Resultado: $resultado"
    }
}