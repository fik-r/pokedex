package com.example.data.api.response

import com.google.gson.annotations.SerializedName

data class ResponsePokedex(
    @SerializedName("results")
    val results: List<ResponsePokemon>
)