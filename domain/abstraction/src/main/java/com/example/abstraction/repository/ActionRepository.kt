package com.example.abstraction.repository

import com.example.model.Catch
import com.example.model.Pokemon
import com.example.model.Release
import com.example.model.Rename
import kotlinx.coroutines.flow.Flow

interface ActionRepository {
    fun catch(pokemon: Pokemon): Flow<Catch>
    fun rename(pokemon: Pokemon): Flow<Rename>
    fun release(pokemon: Pokemon): Flow<Release>
    fun getPokemonsFromInventory(): Flow<List<Pokemon>>
}