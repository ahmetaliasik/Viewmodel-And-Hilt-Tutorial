package com.example.train0.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

sealed class NavigationEvent {
    data class ToSecond(val count: Int) : NavigationEvent()
    data object ToSomething : NavigationEvent()
    data class ToProfile(val userId: String) : NavigationEvent()
}

class HealthViewmodel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count : StateFlow<Int> = _count

    private val _navigation = MutableSharedFlow<NavigationEvent>()
    val navigation: SharedFlow<NavigationEvent> = _navigation.asSharedFlow()

    fun increment(){
        _count.value++
    }

    fun decrement() {
        _count.value--
    }

    fun onGoSecond(count: Int) {
        _navigation.tryEmit(NavigationEvent.ToSecond(count))
    }

    fun onGoSomething() {
        _navigation.tryEmit(NavigationEvent.ToSomething)
    }

    fun onGoProfile(userId: String) {
        _navigation.tryEmit(NavigationEvent.ToProfile(userId))
    }
}