package com.amroid.countrygraphql.data

import com.amroid.CountriesQuery
import com.amroid.CountryQuery
import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryClient
import com.amroid.countrygraphql.domain.CountryDetail
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
    override suspend fun getCountries(): List<Country> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map { it?.toCountryDomain()!! } ?: emptyList()
    }

    override suspend fun getCountry(code: String): CountryDetail?{
        return apolloClient.query(CountryQuery(Optional.present(code))).execute().data?.country?.toCountryDetailDomain()
    }
}