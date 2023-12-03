package com.example.myapplication.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Stats
import com.example.myapplication.databinding.ItemStatBinding
import com.example.myapplication.util.StringExtension.kebabToCapitalCase

class StatAdapter() :
    RecyclerView.Adapter<StatAdapter.ViewHolder>() {

    var stats = listOf<Stats>()

    class ViewHolder(
        private val binding: ItemStatBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(stats: Stats) {
            with(binding) {
                tvStat.text = stats.stat.name.kebabToCapitalCase()
                progressStat.apply {
                    progress = stats.baseStat.toInt()
                    max = 255
                }
                tvStatValue.text = stats.baseStat
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        stats[position].let {
            holder.bindData(it)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemStatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = stats.size
}