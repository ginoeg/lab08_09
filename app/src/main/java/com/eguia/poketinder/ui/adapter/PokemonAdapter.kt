package com.eguia.poketinder.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eguia.poketinder.R
import com.eguia.poketinder.databinding.ItemPokemonBinding
import com.eguia.poketinder.domain.model.Pokemon
import com.eguia.poketinder.util.inflate


class PokemonAdapter(
    var list: List<Pokemon>,
    var callback: Callback
): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_pokemon)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int){
        val item=list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemPokemonBinding.bind(view)

        fun bind(pokemon:Pokemon){
            with(binding){
                root.setOnClickListener{
                    callback.onClickPokemonInformation(pokemon)
                }
                tvName.text = pokemon.name
                Glide
                    .with(itemView)
                    .load(pokemon.getPokemonImage())
                    .into(binding.ivPokemon)
            }
        }
    }

    interface Callback{
        fun onClickPokemonInformation(pokemon: Pokemon)
    }

}