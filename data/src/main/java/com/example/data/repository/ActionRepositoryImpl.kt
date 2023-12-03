package com.example.data.repository

import com.example.abstraction.datasource.ActionLocalDataSource
import com.example.abstraction.datasource.ActionRemoteDataSource
import com.example.abstraction.repository.ActionRepository
import com.example.model.Catch
import com.example.model.Pokemon
import com.example.model.Release
import com.example.model.Rename
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ActionRepositoryImpl(
    private val remote: ActionRemoteDataSource,
    private val local: ActionLocalDataSource
) : ActionRepository {
    override fun catch(pokemon: Pokemon): Flow<Catch> = flow {
        val catch = remote.catch()
        if (catch.status) {
            local.catch(pokemon)
        }
        emit(catch)
    }

    override fun rename(pokemon: Pokemon): Flow<Rename> = flow {
        val rename = remote.rename(pokemon.name)
        local.rename(
            Pokemon(pokemon.id, rename.newName, pokemon.name, "")
        )
        emit(rename)
    }

    override fun release(pokemon: Pokemon): Flow<Release> = flow {
        val release = remote.release()
        if (release.status) {
            local.release(pokemon)
        }
        emit(release)
    }

    override fun getPokemonsFromInventory(): Flow<List<Pokemon>> = flow {
        emit(local.getPokemonsFromInventory())
    }
}