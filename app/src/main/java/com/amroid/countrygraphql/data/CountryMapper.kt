package com.amroid.countrygraphql.data

import com.amroid.CountriesQuery
import com.amroid.CountryQuery
import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryDetail

fun CountriesQuery.Country.toCountryDomain():Country{
  return Country(
    code =  code?:"",
    name= name?:"No Name",
    emoji =  emoji?:"",
    capital = states?.joinToString {
      it?.name.toString()
    }?:""

  )
}
fun CountryQuery.Country.toCountryDetailDomain():CountryDetail{
  return CountryDetail(
    code =  code?:"",
    name= name?:"No Name",
    emoji =  emoji?:"",
    capital = states?.joinToString {
      it?.name.toString()
    }?:"",
    currency = currency?:""

  )
}