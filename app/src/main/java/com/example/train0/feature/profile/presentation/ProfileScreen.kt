package com.example.train0.feature.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.train0.core.ui.preview.TrainPreview
import com.example.train0.feature.profile.domain.ChildSummary
import com.example.train0.feature.profile.domain.ProfileDetail

@Composable
fun ProfileRoute(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    ProfileScreen(uiState = state, modifier = modifier)
}

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (uiState) {
            ProfileUiState.Loading -> CircularProgressIndicator()
            is ProfileUiState.Loaded -> ProfileLoadedContent(detail = uiState.detail)
            is ProfileUiState.Error -> Text(text = uiState.message, color = MaterialTheme.colorScheme.error)
        }
    }
}

@Composable
private fun ProfileLoadedContent(detail: ProfileDetail) {
    Text(text = detail.displayName, style = MaterialTheme.typography.headlineSmall)
    Text(text = "Age: ${detail.ageYears}", style = MaterialTheme.typography.bodyLarge)
    Text(text = "Child: ${detail.child.name}", style = MaterialTheme.typography.bodyLarge)
    Text(text = "Child age: ${detail.child.ageYears}", style = MaterialTheme.typography.bodyLarge)
    Text(text = "User id: ${detail.userId}", style = MaterialTheme.typography.labelLarge)
}

@Preview(showBackground = true, name = "Profile — loaded")
@Composable
private fun ProfileScreenLoadedPreview() {
    TrainPreview {
        ProfileScreen(
            uiState = ProfileUiState.Loaded(
                detail = ProfileDetail(
                    userId = "preview-id",
                    displayName = "Preview User",
                    ageYears = 30,
                    child = ChildSummary(name = "Preview Child", ageYears = 5),
                ),
            ),
        )
    }
}

@Preview(showBackground = true, name = "Profile — loading")
@Composable
private fun ProfileScreenLoadingPreview() {
    TrainPreview {
        ProfileScreen(uiState = ProfileUiState.Loading)
    }
}

@Preview(showBackground = true, name = "Profile — error")
@Composable
private fun ProfileScreenErrorPreview() {
    TrainPreview {
        ProfileScreen(uiState = ProfileUiState.Error("Could not load profile."))
    }
}
