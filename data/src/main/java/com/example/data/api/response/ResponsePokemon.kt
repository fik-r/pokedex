package com.example.data.api.response

import com.google.gson.annotations.SerializedName

data class ResponsePokemon(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)

data class ResponsePokemonDetail(
    @SerializedName("name")
    val baseName: String?,
    @SerializedName("abilities")
    val abilities: List<ResponseAbilities>?,
    @SerializedName("forms")
    val forms: List<ResponseForm>?,
    @SerializedName("sprites")
    val sprite: ResponseSprite?,
    @SerializedName("stats")
    val stats: List<ResponseStats>?,
    @SerializedName("types")
    val types: List<ResponseTypes>?,
    @SerializedName("moves")
    val moves: List<ResponseMoves>?
)

data class ResponseAbilities(
    @SerializedName("ability")
    val ability: ResponseAbility?
)

data class ResponseAbility(
    @SerializedName("name")
    val name: String?
)

data class ResponseMoves(
    @SerializedName("move")
    val move: ResponseMove?
)

data class ResponseMove(
    @SerializedName("name")
    val name: String?
)

data class ResponseForm(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)

data class ResponseSprite(
    @SerializedName("back_default")
    val backDefault: String?,
    @SerializedName("back_female")
    val backFemale: String?,
    @SerializedName("back_shiny")
    val backShiny: String?,
    @SerializedName("back_shiny_female")
    val backShinyFemale: String?,
    @SerializedName("front_default")
    val frontDefault: String?,
    @SerializedName("front_female")
    val frontFemale: String?,
    @SerializedName("front_shiny")
    val frontShiny: String?,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String?
)

data class ResponseTypes(
    @SerializedName("slot")
    val slot: Int?,
    @SerializedName("type")
    val type: ResponseType?
)

data class ResponseType(
    @SerializedName("name")
    val name: String?
)

data class ResponseStats(
    @SerializedName("base_stat")
    val baseStat: String?,
    @SerializedName("stat")
    val stat: ResponseStat?
)

data class ResponseStat(
    @SerializedName("name")
    val name: String?
)