package com.example.train0.feature.hearthbeat.domain

/**
 * Domain model for vitals — independent of UI framework.
 */
data class HearthReading(
    val beatsPerMinute: Int,
    val stepCount: Int,
)
