package com.example.data.datasource

import com.example.abstraction.datasource.PokedexRemoteDataSource
import com.example.data.api.response.mapper.toModel
import com.example.data.api.service.PokedexService
import com.example.model.Pokemon
import com.example.model.PokemonDetail

class PokedexRemoteDataSourceImpl(
    private val pokedexService: PokedexService
) : PokedexRemoteDataSource {
    override suspend fun fetchPokemons(): List<Pokemon> =
        pokedexService.getPokemons().results.toModel()

    override suspend fun fetchDetailPokemon(name: String): PokemonDetail =
        pokedexService.getDetailPokemon(name).toModel()

}