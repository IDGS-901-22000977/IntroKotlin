package com.idgs901.introkotlin.cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.idgs901.introkotlin.R

class Cinepolis : AppCompatActivity() {
    // Precio base por boleto
    private val PRECIO_BOLETO = 12.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        // Configuración de insets para edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            calcularPago()
        }
    }

    private fun calcularPago() {
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCompradores = findViewById<EditText>(R.id.etCompradores)
        val etBoletos = findViewById<EditText>(R.id.etBoletos)
        val rbSi = findViewById<RadioButton>(R.id.rbSi)
        val tvTotal = findViewById<TextView>(R.id.tvTotal)

        try {
            // Obtener valores de entrada
            val nombre = etNombre.text.toString()
            val compradores = etCompradores.text.toString().toInt()
            val boletos = etBoletos.text.toString().toInt()
            val tieneTarjeta = rbSi.isChecked

            // Validaciones
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
                return
            }

            if (boletos > compradores * 7) {
                tvTotal.text = "Máximo ${compradores * 7} boletos (7 por persona)"
                return
            }

            // Cálculo del subtotal
            val subtotal = PRECIO_BOLETO * boletos

            // Aplicar descuentos según cantidad de boletos
            val descuento = when {
                boletos > 5 -> 0.15  // 15% de descuento
                boletos >= 3 -> 0.10 // 10% de descuento
                else -> 0.0          // Sin descuento
            }

            var total = subtotal * (1 - descuento)

            // Aplicar descuento adicional por tarjeta Cineco (10%)
            if (tieneTarjeta) {
                total *= 0.90
            }

            // Mostrar resultados
            val mensaje = """
                Cliente: $nombre
                Boletos: $boletos (Máx permitido: ${compradores * 7})
                Total a pagar: $${"%,.2f".format(total)}
            """.trimIndent()

            tvTotal.text = mensaje

        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}