package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.Pokemon

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val baseName: String = "",
    val name: String = ""
)

fun Pokemon.toEntity(): PokemonEntity {
    return PokemonEntity(
        id = this.id ?: 0,
        baseName = this.name,
        name = this.newName.orEmpty()
    )
}

fun PokemonEntity.toModel(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.baseName,
        newName = this.name,
        url = ""
    )
}

@JvmName("toPokemonsModel")
fun List<PokemonEntity>.toModel(): List<Pokemon> {
    val list = mutableListOf<Pokemon>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

