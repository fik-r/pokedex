package com.example.usecase

import com.example.abstraction.repository.ActionRepository
import com.example.common.UseCase
import com.example.model.Pokemon
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetPokemonsInventoryUseCase(
    private val actionRepository: ActionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<List<Pokemon>, Void>() {
    override fun build(params: Void?): Flow<List<Pokemon>> {
        return actionRepository.getPokemonsFromInventory().flowOn(dispatcher)
    }
}