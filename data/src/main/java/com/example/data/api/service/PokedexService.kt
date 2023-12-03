package com.example.data.api.service

import com.example.data.api.response.ResponsePokedex
import com.example.data.api.response.ResponsePokemonDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexService {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int? = 1000,
    ): ResponsePokedex

    @GET("pokemon/{name}")
    suspend fun getDetailPokemon(
        @Path("name") name: String
    ): ResponsePokemonDetail
}