package com.example.miprimeraappmaterial.ejercicio5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityDetail5Binding

class DetailActivity_5 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val rolUser = intent.getStringExtra("CLAVE_ROL") ?: "Invitado"

        binding.tvAdmin.text = "Rol: $rolUser"

        binding.btnCerrarSesion.setOnClickListener {
            finish()
        }

    }
}