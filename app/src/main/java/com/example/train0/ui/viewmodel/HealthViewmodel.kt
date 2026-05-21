package com.example.train0.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

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
        viewModelScope.launch {
            _navigation.emit(NavigationEvent.ToSecond(count))
        }
    }

    fun onGoSomething() {
        viewModelScope.launch {
            _navigation.emit(NavigationEvent.ToSomething)
        }
    }

    fun onGoProfile(userId: String) {
        viewModelScope.launch {
            _navigation.emit(NavigationEvent.ToProfile(userId))
        }
    }
}