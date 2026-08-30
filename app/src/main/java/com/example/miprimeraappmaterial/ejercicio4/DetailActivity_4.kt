package com.example.miprimeraappmaterial.ejercicio4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityDetail4Binding

class DetailActivity_4 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val saldoRecibido = intent.getDoubleExtra("CLAVE_SALDO", 0.0)

        binding.tvSaldoRecibido.text = "Saldo actual: S/ %.2f".format(saldoRecibido)

        binding.btnConfirmarRetiro.setOnClickListener{

            val etRetiro = binding.etMontoRetiro.text.toString().trim()
            val montoRetiro = etRetiro.toDoubleOrNull()

            if (etRetiro.isEmpty() || montoRetiro == null){
                Toast.makeText(this, "Por favor, ingresa el monto a retirar", Toast.LENGTH_SHORT).show()
            }else{
                if (montoRetiro > saldoRecibido) {
                    Toast.makeText(this, "Saldo insuficiente para este retiro", Toast.LENGTH_SHORT).show()
                }else{
                    val nuevoSaldo = saldoRecibido - montoRetiro

                    val resultIntent = Intent().apply {
                        putExtra("CLAVE_NUEVO_SALDO", nuevoSaldo)
                    }
                    setResult(RESULT_OK, resultIntent)
                    finish()

                }
            }
        }
    }
}