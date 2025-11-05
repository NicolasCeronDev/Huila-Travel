package com.appsnicolas.huilatravel.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsnicolas.huilatravel.data.model.Lugar
import com.appsnicolas.huilatravel.data.network.ApiClient
import com.appsnicolas.huilatravel.databinding.FragmentHomeBinding
import com.appsnicolas.huilatravel.ui.login.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var lugarAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inicializar el adaptador
        lugarAdapter = HomeAdapter()

        // 2. Configurar el RecyclerView
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugarAdapter
        }

        // 3. Obtener los datos
        getLugares()

        binding.loginButton.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getLugares() {
        // Mostrar ProgressBar y ocultar error
        binding.progressBar.isVisible = true
        binding.textError.isVisible = false

        val client = ApiClient.apiService.getLugares()

        client.enqueue(object : Callback<List<Lugar>> {
            override fun onResponse(call: Call<List<Lugar>>, response: Response<List<Lugar>>) {
                binding.progressBar.isVisible = false

                if (response.isSuccessful) {
                    val lugares = response.body()
                    if (lugares != null) {
                        lugarAdapter.updateData(lugares) // <-- CORRECCIÓN AQUÍ
                        Log.d("HOME_FRAGMENT", "Datos recibidos: ${lugares.size} lugares")
                    } else {
                        showError("La respuesta está vacía.")
                    }
                } else {
                    showError("Error en la respuesta del servidor: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Lugar>>, t: Throwable) {
                showError("Fallo en la conexión: ${t.message}")
            }
        })
    }

    private fun showError(message: String) {
        binding.progressBar.isVisible = false
        binding.textError.isVisible = true
        binding.textError.text = message
        Log.e("HOME_FRAGMENT", message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
