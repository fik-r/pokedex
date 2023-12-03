package com.example.data.datasource

import com.example.abstraction.datasource.ActionRemoteDataSource
import com.example.data.api.response.mapper.toModel
import com.example.data.api.service.ActionService
import com.example.model.Catch
import com.example.model.Release
import com.example.model.Rename

class ActionRemoteDataSourceImpl(
    private val actionService: ActionService
) : ActionRemoteDataSource {
    override suspend fun catch(): Catch = actionService.catch().toModel()

    override suspend fun rename(name: String): Rename = actionService.rename(name).toModel()

    override suspend fun release(): Release = actionService.release().toModel()
}