package com.appsnicolas.huilatravel.ui.rutas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RutasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Rutas"
    }
    val text: LiveData<String> = _text
}