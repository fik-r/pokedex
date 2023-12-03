package com.example.abstraction.datasource

import com.example.model.Pokemon

interface ActionLocalDataSource {
    suspend fun getPokemonsFromInventory(): List<Pokemon>
    suspend fun catch(pokemon: Pokemon): Long
    suspend fun release(pokemon: Pokemon)
    suspend fun rename(pokemon: Pokemon)
}