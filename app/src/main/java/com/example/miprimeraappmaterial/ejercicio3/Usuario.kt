package com.example.miprimeraappmaterial.ejercicio3

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Usuario(val name: String, val mail: String, val phone: String) : Parcelable