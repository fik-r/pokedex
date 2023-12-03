package com.example.abstraction.datasource

import com.example.model.Pokemon
import com.example.model.PokemonDetail

interface PokedexRemoteDataSource {
    suspend fun fetchPokemons(): List<Pokemon>
    suspend fun fetchDetailPokemon(name: String): PokemonDetail
}