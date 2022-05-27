package com.eguia.poketinder.data.network

import retrofit2.Response
import retrofit2.http.GET
import com.eguia.poketinder.data.model.PokemonListModel


interface PokemonApi {
    @GET("?limit=20")
    suspend fun  getPokemons(): Response<PokemonListModel>
}