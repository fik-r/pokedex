package com.example.usecase

import com.example.abstraction.repository.ActionRepository
import com.example.common.UseCase
import com.example.model.Pokemon
import com.example.model.Rename
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetRenameUseCase(
    private val actionRepository: ActionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UseCase<Rename, Pokemon>() {
    override fun build(params: Pokemon?): Flow<Rename> {
        requireNotNull(params)
        return actionRepository.rename(params).flowOn(dispatcher)
    }
}