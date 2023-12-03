package com.example.usecase

import com.example.abstraction.repository.ActionRepository
import com.example.common.UseCase
import com.example.model.Catch
import com.example.model.Pokemon
import com.example.model.PokemonDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetCatchUseCase(
    private val actionRepository: ActionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<Catch, Pokemon>() {
    override fun build(params: Pokemon?): Flow<Catch> {
        requireNotNull(params)
        return actionRepository.catch(params).flowOn(dispatcher)
    }
}