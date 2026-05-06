package com.example.train0.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.train0.ui.viewmodel.HealthViewmodel
import com.example.train0.ui.viewmodel.NavigationEvent
import kotlinx.coroutines.flow.collectLatest


@Composable
fun CounterScreen(modifier: Modifier = Modifier, viewModel: HealthViewmodel = viewModel(), navController : NavController) {
    val count by viewModel.count.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.navigation.collectLatest { event ->
            when (event) {
                is NavigationEvent.ToSecond -> navController.navigate("secondScreen/${event.count}")
                NavigationEvent.ToSomething -> navController.navigate(route = "something")
                is NavigationEvent.ToProfile -> navController.navigate(route = "profile/${event.userId}")
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Count: $count", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = { viewModel.decrement() }) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { viewModel.increment() }) {
                Text("+")
            }
        }

        Button(onClick = { viewModel.onGoSecond(count) }) { Text("Go")}

        Button(onClick = { viewModel.onGoSomething() }) { Text("Buggs Bunny") }
        Button(onClick = { viewModel.onGoProfile("1234") }) { Text("Profile") }
    }

}
