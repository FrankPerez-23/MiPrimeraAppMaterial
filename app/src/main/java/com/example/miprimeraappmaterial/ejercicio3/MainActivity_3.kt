package com.example.miprimeraappmaterial.ejercicio3

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityMain3Binding

class MainActivity_3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    private val viewModel: MainViewModel_3 by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            val etNombre = binding.etNombre3.text.toString().trim()
            val etCorreo = binding.etCorreo.text.toString().trim()
            val etTelefono = binding.etTelefono.text.toString().trim()

            val usuario = Usuario(etNombre, etCorreo, etTelefono)

            viewModel.obtenerUsuario(usuario)

            val intent = Intent(this, DetailActivity_3::class.java).apply{
                intent.putExtra("CLAVE_USUARIO", usuario)
            }
        }
    }
}
