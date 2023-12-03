package com.example.data.repository

import com.example.abstraction.datasource.PokedexRemoteDataSource
import com.example.abstraction.repository.PokedexRepository
import com.example.model.Pokemon
import com.example.model.PokemonDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokedexRepositoryImpl(
    private val remote: PokedexRemoteDataSource,
) : PokedexRepository {
    override fun fetchPokemons(): Flow<List<Pokemon>> = flow {
        emit(remote.fetchPokemons())
    }

    override fun fetchDetailPokemon(name: String): Flow<PokemonDetail> = flow {
        emit(remote.fetchDetailPokemon(name))
    }

}