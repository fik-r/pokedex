package com.example.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Catch(
    val status: Boolean
) : Parcelable

@Parcelize
data class Release(
    val status: Boolean,
    val primeNumber: Int
) : Parcelable

@Parcelize
data class Rename(
    val newName: String
) : Parcelable