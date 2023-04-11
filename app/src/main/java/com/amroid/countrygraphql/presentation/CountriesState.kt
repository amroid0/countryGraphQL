package com.amroid.countrygraphql.presentation

import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryDetail

data class CountriesState(
    private val countryList: List<Country> = emptyList(),
    private val isLoading: Boolean = false,
    private val selectedCountry: CountryDetail? = null
)
