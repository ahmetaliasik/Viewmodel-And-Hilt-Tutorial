package com.example.train0.ui.viewmodel

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HealthViewmodel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count : StateFlow<Int> = _count

    fun increment(){
        _count.value++
    }

    fun decrement() {
        _count.value--

    }
}

data class User (val name : String?, val company : String?)


@Composable
fun CounterScreen(modifier: Modifier = Modifier, viewModel: HealthViewmodel = viewModel(), navController : NavController) {
    val count by viewModel.count.collectAsState()

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

        Button(onClick = {
            navController.navigate("secondScreen/${count}")
        }) { Text("Go")}
    }

}

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
