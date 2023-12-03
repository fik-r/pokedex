package com.example.abstraction.datasource

import com.example.model.Catch
import com.example.model.Release
import com.example.model.Rename
import kotlinx.coroutines.flow.Flow

interface ActionRemoteDataSource {
    suspend fun catch(): Catch
    suspend fun rename(name: String): Rename
    suspend fun release(): Release
}