package com.eguia.poketinder.data

import com.eguia.poketinder.data.model.PokemonListModel
import com.eguia.poketinder.data.model.PokemonModel
import com.eguia.poketinder.data.network.PokemonService
import com.eguia.poketinder.domain.model.Pokemon
import com.eguia.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel =pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }
}