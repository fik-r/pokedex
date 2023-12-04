package com.example.myapplication.ui.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.home.adapter.PokedexAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PokedexAdapter
    private val viewModel: InventoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribeLiveData()
        viewModel.getPokemons()
    }

    private fun initViews() {
        with(binding) {
            tvTitle.isVisible = false
            btnInventory.isVisible = false
            btnBack.isVisible = true
            btnBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
            refresh.setOnRefreshListener {
                refresh.isRefreshing = false
                viewModel.getPokemons()
            }
            adapter = PokedexAdapter { name, baseName, id ->
                findNavController().navigate(
                    InventoryFragmentDirections.actionInventoryFragmentToDetailFragment(
                        name,
                        true,
                        baseName,
                        id
                    )
                )
            }
            rvList.apply {
                layoutManager =
                    LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
                adapter = this@InventoryFragment.adapter
            }
        }
    }

    private fun subscribeLiveData() {
        with(viewModel) {
            isLoading.observe(requireActivity()) {
                binding.shimmerList.isVisible = it
                binding.rvList.isVisible = !it
                if(it) binding.shimmerList.startShimmer() else binding.shimmerList.stopShimmer()
            }
            pokemons.observe(requireActivity()) {
                adapter.pokemons = it.toMutableList()
            }
        }
    }
}