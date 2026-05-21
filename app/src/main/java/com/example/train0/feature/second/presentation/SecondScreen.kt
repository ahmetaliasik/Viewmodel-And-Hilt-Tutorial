package com.example.train0.feature.second.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

@Composable
fun SecondRoute(
    modifier: Modifier = Modifier,
    viewModel: SecondViewModel = hiltViewModel(),
) {
    val live by viewModel.liveCount.collectAsStateWithLifecycle()

    SecondScreen(
        modifier = modifier,
        routeArgumentCount = viewModel.routeCount,
        liveSharedCount = live,
    )
}

@Composable
fun SecondScreen(
    routeArgumentCount: Int,
    liveSharedCount: Int,
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
            text = "Route argument count: $routeArgumentCount",
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            text = "Live repository count: $liveSharedCount",
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Preview(showBackground = true, name = "Second")
@Composable
private fun SecondScreenPreview() {
    TrainPreview {
        SecondScreen(routeArgumentCount = 3, liveSharedCount = 10)
    }
}
