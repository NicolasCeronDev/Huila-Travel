package com.appsnicolas.huilatravel.ui.rutas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsnicolas.huilatravel.route.SampleData
import com.appsnicolas.huilatravel.databinding.FragmentRutasBinding

class RutasFragment : Fragment() {

    private var _binding: FragmentRutasBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RoutesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRutasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RoutesAdapter { route ->
        }

        binding.recyclerRutas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerRutas.adapter = adapter

        adapter.submitList(SampleData.routes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}