package com.example.usecase

import com.example.abstraction.repository.PokedexRepository
import com.example.common.UseCase
import com.example.model.Pokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetPokemonsUseCase(
    private val pokedexRepository: PokedexRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<List<Pokemon>, Void>() {
    override fun build(params: Void?): Flow<List<Pokemon>> {
        return pokedexRepository.fetchPokemons().flowOn(dispatcher)
    }
}