package com.example.myapplication.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Types
import com.example.myapplication.databinding.ItemTypeBinding
import com.example.myapplication.util.StringExtension.kebabToCapitalCase

class TypeAdapter() :
    RecyclerView.Adapter<TypeAdapter.ViewHolder>() {

    var types = listOf<Types>()

    class ViewHolder(
        private val binding: ItemTypeBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(types: Types) {
            with(binding) {
                tvType.text = types.type.name.kebabToCapitalCase()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        types[position].let {
            holder.bindData(it)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = types.size
}