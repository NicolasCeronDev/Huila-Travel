package com.appsnicolas.huilatravel.ui.perfil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.appsnicolas.huilatravel.data.SessionManager
import com.appsnicolas.huilatravel.databinding.FragmentPerfilBinding
import com.appsnicolas.huilatravel.ui.login.LoginActivity

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!
    private lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        sessionManager = SessionManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()
        setupClickListeners()
    }

    private fun updateUI() {
        if (sessionManager.isLoggedIn()) {
            binding.layoutLoggedOut.visibility = View.GONE
            binding.layoutLoggedIn.visibility = View.VISIBLE

            binding.tvUserName.text = sessionManager.getUserName()
            binding.tvUserEmail.text = sessionManager.getUserEmail()
            // Aquí puedes actualizar las estadísticas, por ejemplo:
            // binding.tvFavoritesCount.text = "5"
        } else {
            binding.layoutLoggedOut.visibility = View.VISIBLE
            binding.layoutLoggedIn.visibility = View.GONE
        }
    }

    private fun setupClickListeners() {
        // Listeners para la vista de "sesión iniciada"
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(context, "Próximamente: Editar Perfil", Toast.LENGTH_SHORT).show()
        }

        binding.btnMyFavorites.setOnClickListener {
            Toast.makeText(context, "Próximamente: Mis Favoritos", Toast.LENGTH_SHORT).show()
        }

        binding.btnSettings.setOnClickListener {
            Toast.makeText(context, "Próximamente: Ajustes", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            sessionManager.clearAuthData()
            updateUI()
        }

        // Listener para la vista de "sesión no iniciada"
        binding.btnLogin.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
