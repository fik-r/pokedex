package com.example.myapplication.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Abilities
import com.example.myapplication.databinding.ItemAbilityBinding
import com.example.myapplication.util.StringExtension.kebabToCapitalCase

class AbilityAdapter() :
    RecyclerView.Adapter<AbilityAdapter.ViewHolder>() {

    var abilities = listOf<Abilities>()


    class ViewHolder(
        private val binding: ItemAbilityBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(ability: Abilities) {
            with(binding) {
                tvAbility.text = ability.ability.name.kebabToCapitalCase()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        abilities[position].let {
            holder.bindData(it)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAbilityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = abilities.size
}