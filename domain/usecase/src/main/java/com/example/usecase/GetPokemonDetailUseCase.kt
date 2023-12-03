package com.example.usecase

import com.example.abstraction.repository.PokedexRepository
import com.example.common.UseCase
import com.example.model.PokemonDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetPokemonDetailUseCase(
    private val pokedexRepository: PokedexRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<PokemonDetail, GetPokemonDetailUseCase.Params>() {
    override fun build(params: Params?): Flow<PokemonDetail> {
        requireNotNull(params)
        return pokedexRepository.fetchDetailPokemon(params.name).flowOn(dispatcher)
    }

    data class Params(
        val name: String
    )
}