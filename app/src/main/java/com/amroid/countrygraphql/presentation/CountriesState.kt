package com.amroid.countrygraphql.presentation

import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryDetail

data class CountriesState(
    val countryList: List<Country> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: CountryDetail? = null
)
