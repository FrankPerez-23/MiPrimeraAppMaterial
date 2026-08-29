package com.example.miprimeraappmaterial.ejercicio1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityDetailBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar el dato enviado en el Intent
        val nombreRecibido = intent.getStringExtra("CLAVE_NOMBRE") ?: "Sin nombre"
        val apellidoRecibido = intent.getStringExtra("CLAVE_APELLIDO") ?: "Sin apellido"
        val edadRecibido = intent.getStringExtra("CLAVE_EDAD") ?: "Sin edad"

        binding.tvSaludo.text = "Nombre: $nombreRecibido\nApellido: $apellidoRecibido\nEdad: $edadRecibido"

        // Evento: Confirmar cierre con un AlertDialog
        binding.btnVolver.setOnClickListener {
            mostrarDialogoConfirmacion()
        }
    }

    // USO DE ALERTDIALOG: Diálogo de confirmación con Material Design
    private fun mostrarDialogoConfirmacion() {
        MaterialAlertDialogBuilder(this)
            .setTitle(" Confirmación")
            .setMessage("¿Estás seguro de que deseas regresar a la pantalla anterior?")
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss() // Cierra únicamente el diálogo
            }
            .setPositiveButton("Sí, salir") { _, _ ->
                finish() // Cierra la Activity actual
            }
            .show()
    }
}