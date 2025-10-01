package com.appsnicolas.huilatravel.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.appsnicolas.huilatravel.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Obtener referencias
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val etSearch = view.findViewById<EditText>(R.id.et_search) // Keep for now, might be used later

        // 2. Establecer Listeners de forma segura con el operador '?'

        // Botón de Login
        btnLogin?.setOnClickListener {
            Toast.makeText(requireContext(), "Pantalla de inicio de sesión (pendiente)", Toast.LENGTH_SHORT).show()
        }


        // Eventos de Categorías (se requiere el operador '?' para evitar el crash)
        view.findViewById<ImageButton>(R.id.btn_cat_all)?.setOnClickListener {
            Toast.makeText(requireContext(), "Ver todo", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<ImageButton>(R.id.btn_cat_places)?.setOnClickListener {
            Toast.makeText(requireContext(), "Ver Lugares", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<ImageButton>(R.id.btn_cat_food)?.setOnClickListener {
            Toast.makeText(requireContext(), "Ver Comida", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<ImageButton>(R.id.btn_cat_routes)?.setOnClickListener {
            Toast.makeText(requireContext(), "Ver Rutas", Toast.LENGTH_SHORT).show()
        }
    }
}