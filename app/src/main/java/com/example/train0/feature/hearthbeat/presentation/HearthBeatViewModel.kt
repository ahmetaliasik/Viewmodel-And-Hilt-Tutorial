package com.example.train0.feature.hearthbeat.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class HearthBeatViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HearthBeatUiState())
    val uiState: StateFlow<HearthBeatUiState> = _uiState.asStateFlow()
}
