package com.example.miprimeraappmaterial.ejercicio2

import androidx.lifecycle.ViewModel

class MainViewModel_2 : ViewModel() {

    var precioFinal: Double = 0.00
    var montoAhorrado: Double = 0.00

    fun calcularDescuento(precio: Double, descuento:Double) {
        montoAhorrado = precio * (descuento / 100.0)
        precioFinal = precio -  montoAhorrado
    }
}