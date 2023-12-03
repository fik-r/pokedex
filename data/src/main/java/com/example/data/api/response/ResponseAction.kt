package com.example.data.api.response

import com.google.gson.annotations.SerializedName

data class ResponseCatch(
    @SerializedName("success")
    val success: Boolean?
)

data class ResponseRelease(
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("primeNumber")
    val primeNumber: Int?
)

data class ResponseRename(
    @SerializedName("newName")
    val newName: String?
)