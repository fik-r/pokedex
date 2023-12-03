package com.example.myapplication.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.model.Abilities
import com.example.model.Moves
import com.example.model.Pokemon
import com.example.model.Stats
import com.example.model.Types
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.ui.detail.adapter.AbilityAdapter
import com.example.myapplication.ui.detail.adapter.MoveAdapter
import com.example.myapplication.ui.detail.adapter.StatAdapter
import com.example.myapplication.ui.detail.adapter.TypeAdapter
import com.example.myapplication.util.StringExtension.kebabToCapitalCase
import com.google.android.flexbox.FlexboxLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var statAdapter: StatAdapter
    private lateinit var abilityAdapter: AbilityAdapter
    private lateinit var typeAdapter: TypeAdapter
    private lateinit var moveAdapter: MoveAdapter
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentDetailBinding.inflate(LayoutInflater.from(requireActivity()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        subscribeLiveData()
        viewModel.getDetail(args.baseName)
    }

    private fun initViews() {
        with(binding) {
            btnBack.setOnClickListener {
                requireActivity().onBackPressed()
            }
            btnCatch.setOnClickListener {
                viewModel.catch(
                    Pokemon(
                        0,
                        args.name,
                        args.name,
                        url = ""
                    )
                )
            }
            btnRename.setOnClickListener {
                viewModel.rename(
                    Pokemon(
                        args.id,
                        args.name,
                        args.baseName,
                        ""
                    )
                )
            }
            btnRelease.setOnClickListener {
                viewModel.release(
                    Pokemon(
                        args.id,
                        args.name,
                        args.baseName,
                        ""
                    )
                )
            }
            tvTitle.text = args.name.kebabToCapitalCase()
            if (args.isFromInventory) {
                btnRename.isVisible = true
                btnRelease.isVisible = true
            } else
                btnCatch.isVisible = true

        }
    }

    private fun subscribeLiveData() {
        with(viewModel) {
            detail.observe(requireActivity()) {
                with(binding) {
                    Glide.with(this.root)
                        .load(it.sprite.frontDefault)
                        .into(ivSprite)
                }
                setupStat(it.stats)
                setupAbility(it.abilities)
                setupType(it.types)
                setupMove(it.moves.sortedBy { it.move.name })
            }
            catch.observe(requireActivity()) {
                Toast.makeText(
                    requireContext(),
                    if (it) getString(R.string.successfully_catch, args.name) else getString(
                        R.string.failed_to_catch,
                        args.name
                    ),
                    Toast.LENGTH_LONG
                ).show()
            }
            release.observe(requireActivity()) {
                Toast.makeText(
                    requireContext(),
                    if (it) getString(R.string.successfully_release) else getString(R.string.failed_release),
                    Toast.LENGTH_LONG
                ).show()
                if (it)
                    requireActivity().onBackPressed()
            }

            rename.observe(requireActivity()) {
                binding.tvTitle.text = it
            }

            loading.observe(requireActivity()) {
                binding.loading.isVisible = it
            }
        }
    }

    private fun setupStat(stats: List<Stats>) {
        statAdapter = StatAdapter().apply {
            this.stats = stats
        }
        with(binding) {
            rvStats.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            rvStats.adapter = statAdapter
        }
    }

    private fun setupAbility(abilities: List<Abilities>) {
        abilityAdapter = AbilityAdapter().apply {
            this.abilities = abilities
        }
        with(binding) {
            rvAbilities.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            rvAbilities.adapter = abilityAdapter
        }
    }

    private fun setupType(types: List<Types>) {
        typeAdapter = TypeAdapter().apply {
            this.types = types
        }
        with(binding) {
            rvTypes.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            rvTypes.adapter = typeAdapter
        }
    }

    private fun setupMove(moves: List<Moves>) {
        moveAdapter = MoveAdapter().apply {
            this.moves = moves
        }
        with(binding) {
            rvMoves.layoutManager = FlexboxLayoutManager(requireContext())
            rvMoves.adapter = moveAdapter
        }
    }
}