package com.appsnicolas.huilatravel.ui.favoritos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = " Tus favoritos "
    }
    val text: LiveData<String> = _text
}