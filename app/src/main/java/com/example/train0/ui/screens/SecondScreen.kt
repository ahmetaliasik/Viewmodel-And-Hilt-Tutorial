package com.example.train0.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.train0.ui.viewmodel.HealthViewmodel


@Composable
fun SecondScreen(num : Int? = null, viewModel : HealthViewmodel = viewModel()){
    val vmCount = viewModel.count.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Number: $num", style = MaterialTheme.typography.headlineMedium)
        Text(text = "ViewModel  ${vmCount.value}")
    }
}
