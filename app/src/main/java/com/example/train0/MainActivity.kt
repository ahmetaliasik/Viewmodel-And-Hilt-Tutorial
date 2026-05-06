package com.example.train0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.train0.ui.screens.CounterScreen
import com.example.train0.ui.screens.ProfileScreen
import com.example.train0.ui.screens.SecondScreen
import com.example.train0.ui.theme.Train0Theme
import com.example.train0.ui.viewmodel.HealthViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Train0Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        val healthViewModel : HealthViewmodel = viewModel(viewModelStoreOwner = this@MainActivity)
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "counterScreen"
                        ) {
                            composable("counterScreen") { CounterScreen(navController = navController, viewModel = healthViewModel) }
                            composable(
                                route ="secondScreen/{count}",
                                arguments = listOf(navArgument("count") { type = NavType.IntType})
                            ) { backStackEntry ->
                                val countArg = backStackEntry.arguments?.getInt("count")
                                SecondScreen(num = countArg, viewModel = healthViewModel) }
                            composable(route  = "something") { Text("Naber Arkidiş")}
                            composable(route = "profile/{userId}") {
                                backStageEntry ->
                                val userId = backStageEntry.arguments?.getString("userId") ?: return@composable
                                ProfileScreen(userId = userId)
                            }
                        }
                    }
                }
            }
        }
    }
}