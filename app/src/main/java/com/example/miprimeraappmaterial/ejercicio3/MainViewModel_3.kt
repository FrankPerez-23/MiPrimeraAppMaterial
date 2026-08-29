package com.example.miprimeraappmaterial.ejercicio3

import androidx.lifecycle.ViewModel

class MainViewModel_3 : ViewModel() {
    var usuarioGuardado: Usuario? = null //el ? es para avisar q esta variable puede estar vacia

    fun obtenerUsuario(usuario: Usuario){
        usuarioGuardado = usuario
    }
}