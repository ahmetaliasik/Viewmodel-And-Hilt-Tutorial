package com.example.train0.ui.screens

import android.widget.ListView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.tooling.preview.devices.WearDevices

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    ScalingLazyColumn(

    ) { }
}

@Preview(device = WearDevices.SMALL_ROUND)
@Composable
private fun HomeScreenPreview() {
    Scaffold() { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            HomeScreen()
        }
    }
}