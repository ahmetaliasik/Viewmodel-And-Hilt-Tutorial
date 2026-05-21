package com.example.train0.feature.counter.presentation

/**
 * One-shot navigation commands originating from [CounterViewModel].
 */
sealed interface CounterNavigationEffect {
    data class ToSecond(val count: Int) : CounterNavigationEffect
    data object ToSomething : CounterNavigationEffect
    data class ToProfile(val userId: String) : CounterNavigationEffect
    data object ToHomeDemo : CounterNavigationEffect
    data object ToHeartBeatDemo : CounterNavigationEffect
}
