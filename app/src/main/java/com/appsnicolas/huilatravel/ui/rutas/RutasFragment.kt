package com.appsnicolas.huilatravel.ui.rutas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsnicolas.huilatravel.R
import com.appsnicolas.huilatravel.databinding.FragmentRutasBinding
import com.appsnicolas.huilatravel.favorites.FavoritesRepository
import com.appsnicolas.huilatravel.route.SampleData

class RutasFragment : Fragment() {

    private var _binding: FragmentRutasBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RoutesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentRutasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RoutesAdapter(
            onClick = { route ->
                val bundle = bundleOf("routeId" to route.id, "routeTitle" to route.title)
                findNavController().navigate(R.id.navigation_itinerario, bundle)
            },
            onFavoriteClick = { route ->
                FavoritesRepository.add(route)
                Toast.makeText(requireContext(), "Agregado a Favoritos", Toast.LENGTH_SHORT).show()
            }
        )

        binding.recyclerRutas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerRutas.adapter = adapter

        adapter.submitList(SampleData.routes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}