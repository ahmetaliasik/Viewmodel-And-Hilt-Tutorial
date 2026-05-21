package com.example.train0.feature.hearthbeat.presentation

import com.example.train0.feature.hearthbeat.domain.HearthReading

data class HearthBeatUiState(
    val reading: HearthReading = HearthReading(beatsPerMinute = 72, stepCount = 4_820),
)
