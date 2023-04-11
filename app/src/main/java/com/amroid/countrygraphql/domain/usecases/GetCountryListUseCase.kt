package com.amroid.countrygraphql.domain.usecases

import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryClient

class GetCountryListUseCase(private val countryClient: CountryClient) {
    suspend fun execute(): List<Country> {
        return countryClient.getCountries().sortedBy {
            it.name
        }
    }
}