package com.example.miprimeraappmaterial.ejercicio5

import androidx.lifecycle.ViewModel

class MainViewModel_5 : ViewModel(){

    private val _admin:String = "admin"
    private val _password:String = "1234"

    var valido = false

    fun validarAdmin(usuario:String,pass: String): Boolean{
        if(usuario == _admin && pass == _password){
            valido = true
        }else{
            valido = false
        }
        return valido
    }
}