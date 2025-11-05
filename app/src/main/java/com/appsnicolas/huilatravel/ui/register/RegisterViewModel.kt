package com.appsnicolas.huilatravel.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsnicolas.huilatravel.data.model.RegisterRequest
import com.appsnicolas.huilatravel.data.model.RegisterResponse
import com.appsnicolas.huilatravel.data.repository.LoginRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: LoginRepository) : ViewModel() {

    private val _registerResult = MutableLiveData<Result<RegisterResponse>>()
    val registerResult: LiveData<Result<RegisterResponse>> = _registerResult

    fun register(nombre: String, correo: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.register(RegisterRequest(correo, password, nombre))
                if (response.isSuccessful && response.body() != null) {
                    _registerResult.postValue(Result.success(response.body()!!))
                } else {
                    _registerResult.postValue(Result.failure(Exception(response.message())))
                }
            } catch (e: Exception) {
                _registerResult.postValue(Result.failure(e))
            }
        }
    }
}
