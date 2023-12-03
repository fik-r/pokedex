package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.PokemonDao
import com.example.data.database.entity.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}