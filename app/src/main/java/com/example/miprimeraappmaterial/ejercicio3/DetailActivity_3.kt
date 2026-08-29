package com.example.miprimeraappmaterial.ejercicio3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.miprimeraappmaterial.databinding.ActivityDetail3Binding

class DetailActivity_3 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val usuarioRecibido = IntentCompat.getParcelableExtra<Usuario>(intent,"CLAVE_USUARIO", Usuario::class.java)

        binding.tvNombre.text = "Nombre: ${usuarioRecibido.name}"
        binding.tvCorreo.text = "Correo: ${usuarioRecibido.mail}"
        binding.tvTelefono.text = "Telefono: ${usuarioRecibido.phone}"

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}