package com.example.miprimeraappmaterial

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraappmaterial.databinding.ActivityMainBinding

class MainActivity_Original : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivity_Original.inflate(layoutInflater)
        setContentView(R.layout.activity_main_original)
    }
}