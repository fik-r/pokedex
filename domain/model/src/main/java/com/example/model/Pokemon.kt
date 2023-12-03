package com.example.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int? = null,
    var newName: String? = null,
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class PokemonDetail(
    val name: String? = null,
    val baseName: String,
    val abilities: List<Abilities>,
    val forms: List<Form>,
    val sprite: Sprite,
    val stats: List<Stats>,
    val types: List<Types>,
    val moves: List<Moves>
) : Parcelable

@Parcelize
data class Abilities(
    val ability: Ability
) : Parcelable

@Parcelize
data class Ability(
    val name: String
) : Parcelable

@Parcelize
data class Form(
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class Sprite(
    val backDefault: String,
    val backFemale: String,
    val backShiny: String,
    val backShinyFemale: String,
    val frontDefault: String,
    val frontFemale: String,
    val frontShiny: String,
    val frontShinyFemale: String
) : Parcelable

@Parcelize
data class Types(
    val slot: Int,
    val type: Type
) : Parcelable

@Parcelize
data class Type(
    val name: String
) : Parcelable

@Parcelize
data class Stats(
    val baseStat: String,
    val stat: Stat
) : Parcelable

@Parcelize
data class Stat(
    val name: String
) : Parcelable

@Parcelize
data class Moves(
    val move: Move
) : Parcelable

@Parcelize
data class Move(
    val name: String
) : Parcelable