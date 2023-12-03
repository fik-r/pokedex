package com.example.data.api.response.mapper

import com.example.data.api.response.ResponseCatch
import com.example.data.api.response.ResponseRelease
import com.example.data.api.response.ResponseRename
import com.example.model.Catch
import com.example.model.Release
import com.example.model.Rename

fun ResponseCatch.toModel(): Catch {
    return Catch(
        status = this.success ?: false
    )
}

fun ResponseRename.toModel(): Rename {
    return Rename(
        newName = this.newName.orEmpty()
    )
}

fun ResponseRelease.toModel(): Release {
    return Release(
        status = this.status ?: false,
        primeNumber = this.primeNumber ?: 0
    )
}