package com.example.myapplication.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Moves
import com.example.myapplication.databinding.ItemMoveBinding
import com.example.myapplication.util.StringExtension.kebabToCapitalCase

class MoveAdapter() :
    RecyclerView.Adapter<MoveAdapter.ViewHolder>() {

    var moves = listOf<Moves>()


    class ViewHolder(
        private val binding: ItemMoveBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(moves: Moves) {
            with(binding) {
                tvMove.text = moves.move.name.kebabToCapitalCase()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        moves[position].let {
            holder.bindData(it)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMoveBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = moves.size
}