package com.example.miprimeraappmaterial.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
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

            if (etNombre.isEmpty() || etCorreo.isEmpty() || etTelefono.isEmpty()) {
                Toast.makeText(this, "Por favor complete los campos", Toast.LENGTH_SHORT).show()
            }else if (!Patterns.EMAIL_ADDRESS.matcher(etCorreo).matches()){
                binding.etCorreo.error = "Ingresa un correo valido"
                Toast.makeText(this,"El formato del correo no es correcto", Toast.LENGTH_SHORT).show()
            }else if (etTelefono.length < 9) {
                binding.etTelefono.error = "Ingresa un telefono valido"
                Toast.makeText(this,"Coloque un numero valido", Toast.LENGTH_SHORT).show()
            }else{
                val usuario = Usuario(etNombre, etCorreo, etTelefono)

                viewModel.obtenerUsuario(usuario)

                val intent = Intent(this, DetailActivity_3::class.java).apply{
                    putExtra("CLAVE_USUARIO", usuario)
                }
                startActivity(intent)
            }
        }


    }
}
