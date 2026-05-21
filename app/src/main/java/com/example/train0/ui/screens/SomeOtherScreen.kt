package com.example.train0.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import com.example.train0.ui.viewmodel.NewViewmodel
import com.example.train0.ui.viewmodel.SomeOtherScreenNavigation
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SomeOtherScreen(modifier: Modifier = Modifier, viewModel : NewViewmodel, navController : NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(Unit) {
            viewModel.navigation.collectLatest { event ->
                when (event) {
                    is SomeOtherScreenNavigation.FirstScreen -> navController.navigate("first")
                    is SomeOtherScreenNavigation.SecondScreen -> navController.navigate("second")
                    is SomeOtherScreenNavigation.ThirdScreenWithParameters -> navController.navigate("third")
                }

            }
        }
        Text("Canım Benim Git Bakalım Şuraya Buraya")
    }
}