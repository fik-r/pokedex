package com.example.data.datasource

import com.example.abstraction.datasource.ActionLocalDataSource
import com.example.data.database.dao.PokemonDao
import com.example.data.database.entity.toEntity
import com.example.data.database.entity.toModel
import com.example.model.Pokemon

class ActionLocalDataSourceImpl(
    private val pokemonDao: PokemonDao
) : ActionLocalDataSource {
    override suspend fun catch(pokemon: Pokemon): Long =
        pokemonDao.catchPokemon(pokemon.toEntity())

    override suspend fun release(pokemon: Pokemon) =
        pokemonDao.releasePokemon(pokemon.toEntity())

    override suspend fun rename(pokemon: Pokemon) =
        pokemonDao.renamePokemon(pokemon.toEntity())

    override suspend fun getPokemonsFromInventory(): List<Pokemon> =
        pokemonDao.getPokemons().toModel()
}