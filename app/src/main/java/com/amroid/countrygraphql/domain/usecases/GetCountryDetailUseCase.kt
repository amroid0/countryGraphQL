package com.amroid.countrygraphql.domain.usecases

import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryClient
import com.amroid.countrygraphql.domain.CountryDetail

class GetCountryDetailUseCase(private val countryClient: CountryClient) {
    suspend fun execute(code: String): CountryDetail? {
        return countryClient.getCountry(code)
    }
}