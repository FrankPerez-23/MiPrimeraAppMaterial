package com.example.miprimeraappmaterial.ejercicio4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.miprimeraappmaterial.databinding.ActivityMain4Binding

class MainActivity_4 : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding
    private val viewModel: MainViewModel_4 by viewModels()

    private val launcherRetiro = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val nuevoSaldo = result.data?.getDoubleExtra("CLAVE_NUEVO_SALDO", 0.0) ?: 0.0

            viewModel.actualizarSaldo(nuevoSaldo)
            binding.tvSaldoActual.text = "S/ %.2f".format(viewModel.saldoActual)

            Toast.makeText(this, "Retiro realizado con éxito", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRetiro.setOnClickListener {
            val etSaldo = binding.etSaldoInicial.text.toString().trim()
            val saldoDouble = etSaldo.toDoubleOrNull()

            if (etSaldo.isEmpty() || saldoDouble == null){
                Toast.makeText(this, "Ingresa el saldo", Toast.LENGTH_SHORT).show()
            }else{

                viewModel.saldoActual = saldoDouble
                binding.tvSaldoActual.text = "S/ %.2f".format(viewModel.saldoActual)

                val intent = Intent(this, DetailActivity_4::class.java).apply {
                    putExtra("CLAVE_SALDO", viewModel.saldoActual)
                }
                launcherRetiro.launch(intent)
            }
        }
    }
}