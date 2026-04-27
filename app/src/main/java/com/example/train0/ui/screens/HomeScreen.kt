package com.example.train0.ui.screens

import android.widget.ListView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column() {
        Text("Adım Sayar : ")
        Text("Kalp Atışı : ")
        Text("Sıcaklık : ")
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    Scaffold() { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            HomeScreen()
        }
    }
}