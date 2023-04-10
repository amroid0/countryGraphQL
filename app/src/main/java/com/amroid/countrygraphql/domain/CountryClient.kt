package com.amroid.countrygraphql.domain

import com.amroid.CountriesQuery
import com.amroid.CountryQuery

interface CountryClient {
  suspend fun getCountries():List<Country>
  suspend fun getCountry(code:String):List<CountryDetail>
}