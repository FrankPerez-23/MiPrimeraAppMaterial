package com.example.miprimeraappmaterial.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityMain2Binding

class MainActivity_2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private val viewModel: MainViewModel_2 by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAhorro.setOnClickListener {
            val textPrecio = binding.etPrecio.text.toString().trim()
            val textPorcent = binding.etDescuento.text.toString().trim()

            if (textPrecio.isEmpty() || textPorcent.isEmpty()){
                Toast.makeText(this, "Por favor complete los campos", Toast.LENGTH_SHORT).show()
            }

            val precio = textPrecio.toDouble()
            val descuento = textPorcent.toDouble()

            viewModel.calcularDescuento(precio, descuento)

            val intent = Intent(this, DetailActivity_2::class.java).apply {
                putExtra("CLAVE_PRECIO", viewModel.precioFinal)
                putExtra("CLAVE_AHORRO", viewModel.montoAhorrado)
            }
            startActivity(intent)
        }
    }
}