package com.example.abstraction.repository

import com.example.model.Pokemon
import com.example.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun fetchPokemons(): Flow<List<Pokemon>>
    fun fetchDetailPokemon(name: String): Flow<PokemonDetail>
}