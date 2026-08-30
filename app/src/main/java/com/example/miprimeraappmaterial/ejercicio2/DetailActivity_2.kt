package com.example.miprimeraappmaterial.ejercicio2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityDetail2Binding

class DetailActivity_2 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val precioRecibido = intent.getDoubleExtra("CLAVE_PRECIO", 0.0)
        val ahorroRecibido = intent.getDoubleExtra("CLAVE_AHORRO",0.0)

        if(ahorroRecibido > 50){
            binding.tvAhorro.text = "Felicidades!! Ahorraste S/ $ahorroRecibido en esta compra"
            binding.tvAhorro.setTextColor(getColor(android.R.color.holo_green_dark))
        }else{
            binding.tvAhorro.text = "Ahorraste S/ $ahorroRecibido"
            binding.tvAhorro.setTextColor(getColor(android.R.color.darker_gray))
        }
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}