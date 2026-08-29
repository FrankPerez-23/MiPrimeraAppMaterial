package com.example.miprimeraappmaterial.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Evento 1: Validar, guardar en ViewModel y navegar
        binding.btnEnviar.setOnClickListener {
            val textoNombre = binding.etNombre.text.toString().trim()
            val textoApellido = binding.etApellido.text.toString().trim()
            val textoEdad = binding.etEdad.text.toString().trim()

            if (textoNombre.isEmpty() || textoApellido.isEmpty() || textoEdad.isEmpty()) {
                // USO DE TOAST: Mensaje rápido si el campo está vacío
                Toast.makeText(this, "Por favor, complete todos los campos",
                    Toast.LENGTH_SHORT).show()
            } else {
                viewModel.nombreUsuario = textoNombre
                viewModel.apellidoUsuario = textoApellido
                viewModel.edadUsuario = textoEdad

                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("CLAVE_NOMBRE", viewModel.nombreUsuario)
                    putExtra("CLAVE_APELLIDO", viewModel.apellidoUsuario)
                    putExtra("CLAVE_EDAD", viewModel.edadUsuario)
                }
                startActivity(intent)
            }
        }

        // Evento 2: Ejemplo de Snackbar con acción
        binding.btnProbarSnackbar.setOnClickListener { view ->
            // USO DE SNACKBAR: Mensaje de Material Design con botón de acción
            Snackbar.make(view, "Este es un mensaje informativo",
                Snackbar.LENGTH_LONG)
                .setAction("Entendido") {
                    Toast.makeText(this, "Hiciste clic en el Snackbar",
                        Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}