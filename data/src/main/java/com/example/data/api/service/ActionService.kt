package com.example.data.api.service

import com.example.data.api.response.ResponseCatch
import com.example.data.api.response.ResponseRelease
import com.example.data.api.response.ResponseRename
import retrofit2.http.GET
import retrofit2.http.Query

interface ActionService {
    @GET("catch")
    suspend fun catch() : ResponseCatch

    @GET("release")
    suspend fun release(): ResponseRelease

    @GET("rename")
    suspend fun rename(
        @Query("name") name: String
    ): ResponseRename
}