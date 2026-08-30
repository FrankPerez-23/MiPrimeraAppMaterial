package com.example.miprimeraappmaterial.ejercicio4

import androidx.lifecycle.ViewModel

class MainViewModel_4 : ViewModel() {
    var saldoActual: Double = 0.0

    fun actualizarSaldo(newSaldo: Double) {
        saldoActual = newSaldo
    }
}