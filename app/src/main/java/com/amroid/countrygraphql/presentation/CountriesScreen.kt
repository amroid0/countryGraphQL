package com.amroid.countrygraphql.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.amroid.countrygraphql.domain.Country
import com.amroid.countrygraphql.domain.CountryDetail

@Composable
fun CountriesScreen(
  state: CountriesState,
  onCountrySelected: (code: String) -> Unit,
  onDismissDialog: () -> Unit
) {
  Box(modifier = Modifier.fillMaxSize()) {
    if (state.isLoading) {
      CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    } else {
      LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.countryList) { country ->
          countryItem(
            country = country,
            modifier = Modifier
              .fillMaxWidth()
              .clickable { onCountrySelected(country.code) }
              .padding(16.dp),
          )

        }
      }
      if (state.selectedCountry != null) {
        CountryDialog(
          country = state.selectedCountry, onDismiss = onDismissDialog, modifier = Modifier
            .clip(
              RoundedCornerShape(5.dp)
            )
            .background(Color.White)
            .padding(16.dp)
        )
      }
    }

  }

}

@Composable
fun countryItem(
  country: Country,
  modifier: Modifier
) {
  Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
    Text(text = country.emoji, fontSize = 30.sp)
    Spacer(modifier = Modifier.width(16.dp))
    Column(modifier = Modifier.weight(1f)) {
      Text(text = country.name, fontSize = 24.sp)
      Spacer(modifier = Modifier.height(16.dp))
      Text(text = country.capital)


    }
  }
}

@Composable
fun CountryDialog(country: CountryDetail, onDismiss: () -> Unit, modifier: Modifier) {
  Dialog(onDismissRequest = onDismiss) {
    Column(modifier = modifier) {
      Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = country.emoji, fontSize = 30.sp)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = country.name, fontSize = 24.sp)

      }
      Spacer(modifier = Modifier.height(16.dp))
      Text(text = "continent :${country.continent}")
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = "capital :${country.capital}")
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = "currency :${country.currency}")
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = "languages :${country.languages}")


    }
  }
}