package com.example.miprimeraappmaterial

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityMainOriginalBinding
import com.example.miprimeraappmaterial.ejercicio1.MainActivity
import com.example.miprimeraappmaterial.ejercicio2.MainActivity_2
import com.example.miprimeraappmaterial.ejercicio3.MainActivity_3
import com.example.miprimeraappmaterial.ejercicio4.MainActivity_4
import com.example.miprimeraappmaterial.ejercicio5.MainActivity_5

class MainActivity_Original : AppCompatActivity() {

    private lateinit var binding: ActivityMainOriginalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainOriginalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEjercicio1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnEjercicio2.setOnClickListener {
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
        }
        binding.btnEjercicio3.setOnClickListener {
            val intent = Intent(this, MainActivity_3::class.java)
            startActivity(intent)
        }
        binding.btnEjercicio4.setOnClickListener {
            val intent = Intent(this, MainActivity_4::class.java)
            startActivity(intent)
        }
        binding.btnEjercicio5.setOnClickListener {
            val intent = Intent(this, MainActivity_5::class.java)
            startActivity(intent)
        }
    }
}