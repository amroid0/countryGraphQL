package com.amroid.countrygraphql.domain

import com.amroid.CountryQuery

data class CountryDetail(
   val code: String,
   val name: String,
   val emoji: String,
   val currency: String,
   val capital: String,
   val languages: List<String>,
   val continent: String,
)
