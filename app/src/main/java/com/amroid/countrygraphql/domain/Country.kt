package com.amroid.countrygraphql.domain


data class Country(
        val code: String,
        val name: String,
        val emoji: String,
        val capital: String
)