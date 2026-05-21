package com.example.train0.feature.profile.presentation

import com.example.train0.feature.profile.domain.ProfileDetail

sealed interface ProfileUiState {
    data object Loading : ProfileUiState
    data class Loaded(val detail: ProfileDetail) : ProfileUiState
    data class Error(val message: String) : ProfileUiState
}
