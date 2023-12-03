package com.example.myapplication.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Pokemon
import com.example.myapplication.databinding.ItemPokedexBinding
import com.example.myapplication.util.StringExtension.kebabToCapitalCase

class PokedexAdapter(private val onItemClick: (name: String, baseName: String, id: Int) -> Unit) :
    RecyclerView.Adapter<PokedexAdapter.ViewHolder>() {

    var pokemons = mutableListOf<Pokemon>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(
        private val binding: ItemPokedexBinding,
        private val onItemClick: (name: String, baseName: String, id: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(pokemon: Pokemon) {
            with(binding) {
                tvNumber.text = "#${absoluteAdapterPosition + 1}"
                tvName.text = pokemon.newName?.kebabToCapitalCase().orEmpty()
                root.setOnClickListener {
                    onItemClick.invoke(pokemon.newName.orEmpty(), pokemon.name, pokemon.id ?: 0)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        pokemons[position].let {
            holder.bindData(it)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPokedexBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onItemClick
        )
    }

    override fun getItemCount(): Int = pokemons.size
}