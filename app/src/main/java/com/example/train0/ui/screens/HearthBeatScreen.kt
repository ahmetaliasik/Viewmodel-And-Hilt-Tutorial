package com.example.train0.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HearthBeatScreen(modifier: Modifier = Modifier) {
    
}

@Preview(device = Devices)
@Composable
private fun HearthBeatPreview() {
    val hearthBeat : Int = 10
    Scaffold() {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column() {
                Text("$hearthBeat b/m")
            }
        }
    }
}