package com.amroid.countrygraphql.data

import com.amroid.CountriesQuery
import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryClient
import com.amroid.countrygraphql.domain.CountryDetail
import com.apollographql.apollo3.ApolloClient

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {
  override suspend fun getCountries(): List<Country> {
   return apolloClient.query(CountriesQuery()).execute().data?.countries.map {  }
  }

  override suspend fun getCountry(code: String): List<CountryDetail> {
  }
}