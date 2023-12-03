package com.example.usecase

import com.example.abstraction.repository.ActionRepository
import com.example.common.UseCase
import com.example.model.Pokemon
import com.example.model.PokemonDetail
import com.example.model.Release
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetReleaseUseCase(
    private val actionRepository: ActionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<Release, Pokemon>() {
    override fun build(params: Pokemon?): Flow<Release> {
        requireNotNull(params)
        return actionRepository.release(pokemon = params).flowOn(dispatcher)
    }
}