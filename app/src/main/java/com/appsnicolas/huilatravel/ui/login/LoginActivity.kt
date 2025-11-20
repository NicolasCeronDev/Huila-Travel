package com.appsnicolas.huilatravel.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.appsnicolas.huilatravel.data.model.LoginRequest
import com.appsnicolas.huilatravel.data.network.ApiClient
import com.appsnicolas.huilatravel.data.SessionManager
import com.appsnicolas.huilatravel.databinding.ActivityLoginBinding
import com.appsnicolas.huilatravel.ui.register.RegisterActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val loginRequest = LoginRequest(email, password)
                loginUser(loginRequest)
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun loginUser(loginRequest: LoginRequest) {
        lifecycleScope.launch {
            try {
                val response = ApiClient.apiService.login(loginRequest)
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.usuario != null) {
                        Toast.makeText(this@LoginActivity, loginResponse.mensaje, Toast.LENGTH_SHORT).show()
                        sessionManager.saveAuthData(
                            loginResponse.usuario.id.toString(),
                            loginResponse.usuario.nombre,
                            loginResponse.usuario.correo
                        )
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Error: ${loginResponse?.mensaje}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Toast.makeText(this@LoginActivity, "Error ${response.code()}: $errorBody", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@LoginActivity, "Error de conexión: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
