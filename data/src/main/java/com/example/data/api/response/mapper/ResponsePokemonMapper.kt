package com.example.data.api.response.mapper

import com.example.data.api.response.ResponseAbilities
import com.example.data.api.response.ResponseAbility
import com.example.data.api.response.ResponseForm
import com.example.data.api.response.ResponseMove
import com.example.data.api.response.ResponseMoves
import com.example.data.api.response.ResponsePokemon
import com.example.data.api.response.ResponsePokemonDetail
import com.example.data.api.response.ResponseSprite
import com.example.data.api.response.ResponseStat
import com.example.data.api.response.ResponseStats
import com.example.data.api.response.ResponseType
import com.example.data.api.response.ResponseTypes
import com.example.model.Abilities
import com.example.model.Ability
import com.example.model.Form
import com.example.model.Move
import com.example.model.Moves
import com.example.model.Pokemon
import com.example.model.PokemonDetail
import com.example.model.Sprite
import com.example.model.Stat
import com.example.model.Stats
import com.example.model.Type
import com.example.model.Types

fun ResponsePokemon.toModel(): Pokemon {
    return Pokemon(
        newName = this.name.orEmpty(),
        name = this.name.orEmpty(),
        url = this.url.orEmpty()
    )
}

@JvmName("toListPokemonModel")
fun List<ResponsePokemon>.toModel(): List<Pokemon> {
    val list = mutableListOf<Pokemon>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

fun ResponsePokemonDetail.toModel(): PokemonDetail {
    return PokemonDetail(
        baseName = this.baseName.orEmpty(),
        abilities = this.abilities?.toModel() ?: emptyList(),
        forms = this.forms?.toModel() ?: emptyList(),
        sprite = this.sprite?.toModel() ?: Sprite(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        ),
        stats = this.stats?.toModel() ?: emptyList(),
        types = this.types?.toModel() ?: emptyList(),
        moves = this.moves?.toModel() ?: emptyList()
    )
}

/** PARSING ABILITY MODEL */
@JvmName("toAbilitiesModel")
fun List<ResponseAbilities>.toModel(): List<Abilities> {
    val list = mutableListOf<Abilities>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

fun ResponseAbilities.toModel(): Abilities {
    return Abilities(
        ability = this.ability?.toModel() ?: Ability("")
    )
}

fun ResponseAbility.toModel(): Ability {
    return Ability(
        name = this.name.orEmpty()
    )
}
/** END */

/** PARSING FORM MODEL */
@JvmName("toListFormModel")
fun List<ResponseForm>.toModel(): List<Form> {
    val list = mutableListOf<Form>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

fun ResponseForm.toModel(): Form {
    return Form(
        name = this.name.orEmpty(),
        url = this.url.orEmpty()
    )
}
/** END */

/** PARSING SPRITE MODEL */
fun ResponseSprite.toModel(): Sprite {
    return Sprite(
        backDefault = this.backDefault.orEmpty(),
        backFemale = this.backFemale.orEmpty(),
        backShiny = this.backShiny.orEmpty(),
        backShinyFemale = this.backShinyFemale.orEmpty(),
        frontDefault = this.frontDefault.orEmpty(),
        frontFemale = this.frontFemale.orEmpty(),
        frontShiny = this.frontShiny.orEmpty(),
        frontShinyFemale = this.frontShinyFemale.orEmpty()
    )
}
/** END */

/** PARSING TYPE MODEL */
@JvmName("toTypesModel")
fun List<ResponseTypes>.toModel(): List<Types> {
    val list = mutableListOf<Types>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

fun ResponseTypes.toModel(): Types {
    return Types(
        type = this.type?.toModel() ?: Type(""),
        slot = this.slot ?: 0
    )
}

fun ResponseType.toModel(): Type {
    return Type(
        name = this.name.orEmpty()
    )
}
/** END */

/** STAT */
@JvmName("toStatsModel")
fun List<ResponseStats>.toModel(): List<Stats> {
    val list = mutableListOf<Stats>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

fun ResponseStats.toModel(): Stats {
    return Stats(
        baseStat = this.baseStat.orEmpty(),
        stat = this.stat?.toModel() ?: Stat("")
    )
}

fun ResponseStat.toModel(): Stat {
    return Stat(
        name = this.name.orEmpty()
    )
}
/** END */

/** MOVE */
@JvmName("toMovesModel")
fun List<ResponseMoves>.toModel(): List<Moves> {
    val list = mutableListOf<Moves>()
    this.forEach {
        list.add(it.toModel())
    }
    return list
}

fun ResponseMoves.toModel(): Moves {
    return Moves(
        move = this.move?.toModel() ?: Move("")
    )
}

fun ResponseMove.toModel(): Move {
    return Move(
        name = this.name.orEmpty()
    )
}

