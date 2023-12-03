package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.database.entity.PokemonEntity

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun catchPokemon(pokemonEntity: PokemonEntity): Long

    @Delete
    suspend fun releasePokemon(pokemonEntity: PokemonEntity)

    @Update
    suspend fun renamePokemon(pokemonEntity: PokemonEntity)

    @Query("Select * From pokemon")
    suspend fun getPokemons(): List<PokemonEntity>
}