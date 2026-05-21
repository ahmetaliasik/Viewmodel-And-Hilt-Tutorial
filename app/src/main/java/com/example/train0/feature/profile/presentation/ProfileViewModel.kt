package com.example.train0.feature.profile.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.train0.data.profile.ProfileRepository
import com.example.train0.navigation.TrainRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val profileRepository: ProfileRepository,
) : ViewModel() {

    private val userId: String =
        checkNotNull(savedStateHandle.get<String>(TrainRoutes.Args.USER_ID)) {
            "Route `${TrainRoutes.PROFILE_PATTERN}` requires `${TrainRoutes.Args.USER_ID}`"
        }

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            runCatching { profileRepository.getProfile(userId) }
                .onSuccess { detail -> _uiState.value = ProfileUiState.Loaded(detail) }
                .onFailure { e ->
                    _uiState.value = ProfileUiState.Error(e.message ?: "Unknown error")
                }
        }
    }
}
