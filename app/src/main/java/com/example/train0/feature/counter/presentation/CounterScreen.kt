package com.example.train0.feature.counter.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.train0.core.ui.preview.TrainPreview
import com.example.train0.navigation.TrainRoutes
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CounterRoute(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel = hiltViewModel(),
) {
    val count by viewModel.count.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel, navController) {
        viewModel.navigationEffects.collectLatest { effect ->
            when (effect) {
                is CounterNavigationEffect.ToSecond ->
                    navController.navigate(TrainRoutes.second(effect.count))
                CounterNavigationEffect.ToSomething ->
                    navController.navigate(TrainRoutes.SOMETHING)
                is CounterNavigationEffect.ToProfile ->
                    navController.navigate(TrainRoutes.profile(effect.userId))
                CounterNavigationEffect.ToHomeDemo ->
                    navController.navigate(TrainRoutes.HOME)
                CounterNavigationEffect.ToHeartBeatDemo ->
                    navController.navigate(TrainRoutes.HEARTH_BEAT)
            }
        }
    }

    CounterScreen(
        modifier = modifier,
        count = count,
        onIncrement = viewModel::increment,
        onDecrement = viewModel::decrement,
        onGoSecond = { viewModel.onGoSecond(count) },
        onGoSomething = viewModel::onGoSomething,
        onGoProfile = { viewModel.onGoProfile("1234") },
        onGoHomeDemo = viewModel::onGoHomeDemo,
        onGoHeartBeatDemo = viewModel::onGoHeartBeatDemo,
    )
}

@Composable
fun CounterScreen(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onGoSecond: () -> Unit,
    onGoSomething: () -> Unit,
    onGoProfile: () -> Unit,
    onGoHomeDemo: () -> Unit,
    onGoHeartBeatDemo: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Count: $count", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = onDecrement) { Text("-") }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = onIncrement) { Text("+") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onGoSecond) { Text("Go second") }
        Button(onClick = onGoSomething) { Text("Something screen") }
        Button(onClick = onGoProfile) { Text("Profile") }
        Button(onClick = onGoHomeDemo) { Text("Home (demo route)") }
        Button(onClick = onGoHeartBeatDemo) { Text("Heart beat (demo route)") }
    }
}

@Preview(showBackground = true, name = "Counter — default")
@Composable
private fun CounterScreenPreview() {
    TrainPreview {
        CounterScreen(
            count = 7,
            onIncrement = {},
            onDecrement = {},
            onGoSecond = {},
            onGoSomething = {},
            onGoProfile = {},
            onGoHomeDemo = {},
            onGoHeartBeatDemo = {},
        )
    }
}
