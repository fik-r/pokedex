package com.example.myapplication.util


object StringExtension {
    fun String.kebabToCapitalCase(): String {
        val words = this.split("-")
        val capitalWords = words.map { it.replaceFirstChar { it.uppercase() } }
        return capitalWords.joinToString(" ")
    }
}