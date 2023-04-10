package com.amroid.countrygraphql.domain

import com.amroid.CountriesQuery
import com.amroid.CountryQuery

interface CountryClient {
  suspend fun getCountries():List<CountriesQuery.Country>
  suspend fun getCountry(code:String):List<CountryQuery.Country>
}