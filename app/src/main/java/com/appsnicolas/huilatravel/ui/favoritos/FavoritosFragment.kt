package com.appsnicolas.huilatravel.ui.favoritos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsnicolas.huilatravel.databinding.FragmentFavoritosBinding
import androidx.navigation.fragment.findNavController
import com.appsnicolas.huilatravel.favorites.FavoritesRepository

class FavoritosFragment : Fragment() {

    private var _binding: FragmentFavoritosBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FavoritesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavoritesAdapter(
            onItemClick = { route ->
                Toast.makeText(requireContext(), "Abrir: ${route.title}", Toast.LENGTH_SHORT).show()
            },
            onRemoveClick = { route ->
                FavoritesRepository.remove(route)
                Toast.makeText(requireContext(), "Eliminado de Favoritos", Toast.LENGTH_SHORT).show()
            }
        )

        binding.recyclerFavoritos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFavoritos.adapter = adapter

        FavoritesRepository.favorites.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.emptyContainer.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
        }

        binding.buttonExplorar.setOnClickListener {
            findNavController().navigate(com.appsnicolas.huilatravel.R.id.navigation_rutas)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
