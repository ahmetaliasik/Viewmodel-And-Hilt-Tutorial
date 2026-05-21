package com.example.train0.feature.hearthbeat.presentation

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
fun HearthBeatRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HearthBeatViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HearthBeatScreen(
        modifier = modifier,
        uiState = state,
        onBack = { navController.navigateUp() },
    )
}

@Composable
fun HearthBeatScreen(
    uiState: HearthBeatUiState,
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
        Text(
            text = "${uiState.reading.beatsPerMinute} bpm",
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = "${uiState.reading.stepCount} steps",
            style = MaterialTheme.typography.bodyLarge,
        )
        Button(onClick = onBack, modifier = Modifier.padding(top = 24.dp)) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true, name = "Heart beat")
@Composable
private fun HearthBeatScreenPreview() {
    TrainPreview {
        HearthBeatScreen(
            uiState = HearthBeatUiState(),
            onBack = {},
        )
    }
}
