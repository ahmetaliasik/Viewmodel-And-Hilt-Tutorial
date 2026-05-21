package com.example.train0.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.train0.feature.counter.presentation.CounterRoute
import com.example.train0.feature.hearthbeat.presentation.HearthBeatRoute
import com.example.train0.feature.home.presentation.HomeRoute
import com.example.train0.feature.profile.presentation.ProfileRoute
import com.example.train0.feature.second.presentation.SecondRoute
import com.example.train0.feature.something.presentation.SomethingRoute

/**
 * Single entry for the app navigation graph. Add new destinations here to keep scaling predictable.
 */
@Composable
fun TrainNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TrainRoutes.COUNTER,
    ) {
        composable(route = TrainRoutes.COUNTER) {
            CounterRoute(navController = navController)
        }

        composable(
            route = TrainRoutes.SECOND_PATTERN,
            arguments = listOf(
                navArgument(TrainRoutes.Args.COUNT) { type = NavType.IntType },
            ),
        ) {
            SecondRoute()
        }

        composable(route = TrainRoutes.SOMETHING) {
            SomethingRoute(navController = navController)
        }

        composable(
            route = TrainRoutes.PROFILE_PATTERN,
            arguments = listOf(
                navArgument(TrainRoutes.Args.USER_ID) { type = NavType.StringType },
            ),
        ) {
            ProfileRoute()
        }

        composable(route = TrainRoutes.HOME) {
            HomeRoute(navController = navController)
        }

        composable(route = TrainRoutes.HEARTH_BEAT) {
            HearthBeatRoute(navController = navController)
        }
    }
}
