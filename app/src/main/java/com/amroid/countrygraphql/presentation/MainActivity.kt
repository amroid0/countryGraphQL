package com.amroid.countrygraphql.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val viewModel = hiltViewModel<CountriesViewModel>()
      val state by viewModel.state.collectAsState()
      CountriesScreen(state = state, onCountrySelected = {
        viewModel.selectCountry(it)
      }, onDismissDialog = {
        viewModel.dismissCountryDialog()
      })
    }
  }
}