package com.example.miprimeraappmaterial.ejercicio5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityMain5Binding
import com.google.android.material.snackbar.Snackbar

class MainActivity_5 : AppCompatActivity() {

    private lateinit var binding: ActivityMain5Binding
    private val viewModel: MainViewModel_5 by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnValidar.setOnClickListener { view ->
            val admin = binding.etUsuario.text.toString().trim()
            val contra = binding.etPassword.text.toString().trim()

            if (admin.isEmpty() || contra.isEmpty()){
                Toast.makeText(this,"Completo los 2 campos", Toast.LENGTH_SHORT).show()
            }else{

                val validado = viewModel.validarAdmin(admin,contra)

                if (validado){
                    val intent = Intent(this, DetailActivity_5::class.java).apply{
                        putExtra("CLAVE_ROL","Administrador")
                    }
                    startActivity(intent)
                    finish()
                }else {
                    Snackbar.make(view, "Los datos son incorrectos", Snackbar.LENGTH_LONG)
                        .setAction("Entendido") {}.show()
                }
            }
        }

    }
}