package com.example.train0.feature.something.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import com.example.train0.core.ui.preview.TrainPreview

@Composable
fun SomethingRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SomethingViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    SomethingScreen(
        modifier = modifier,
        uiState = state,
        onBack = { navController.navigateUp() },
    )
}

@Composable
fun SomethingScreen(
    uiState: SomethingUiState,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = uiState.title, style = MaterialTheme.typography.headlineMedium)
        Text(text = uiState.subtitle, style = MaterialTheme.typography.bodyLarge)
        Button(onClick = onBack, modifier = Modifier.padding(top = 24.dp)) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true, name = "Something")
@Composable
private fun SomethingScreenPreview() {
    TrainPreview {
        SomethingScreen(
            uiState = SomethingUiState(title = "Something", subtitle = "Preview body"),
            onBack = {},
        )
    }
}
