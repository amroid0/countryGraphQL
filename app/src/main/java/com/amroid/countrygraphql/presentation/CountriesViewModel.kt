package com.amroid.countrygraphql.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amroid.countrygraphql.domain.usecases.GetCountryDetailUseCase
import com.amroid.countrygraphql.domain.usecases.GetCountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val listUseCase: GetCountryListUseCase,
    private val detailUseCase: GetCountryDetailUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CountriesState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            _state.update {
                it.copy(
                    isLoading = false,
                    countryList = listUseCase.execute()
                )
            }

        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(selectedCountry = detailUseCase.execute(code))
            }
        }
    }

    fun dismissCountryDialog() {
        _state.update {
            it.copy(selectedCountry = null)
        }
    }


}