package com.example.train0.feature.something.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SomethingUiState(
    val title: String = "Something",
    val subtitle: String = "Placeholder route — replace with real feature UI.",
)

@HiltViewModel
class SomethingViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(SomethingUiState())
    val uiState: StateFlow<SomethingUiState> = _uiState.asStateFlow()
}
