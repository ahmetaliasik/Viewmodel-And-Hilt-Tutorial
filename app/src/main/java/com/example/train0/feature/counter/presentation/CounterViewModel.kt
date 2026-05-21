package com.example.train0.feature.counter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.train0.data.counter.CounterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterRepository: CounterRepository,
) : ViewModel() {

    val count: StateFlow<Int> = counterRepository
        .observeCount()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)

    private val _navigationEffects = MutableSharedFlow<CounterNavigationEffect>(
        extraBufferCapacity = 32,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val navigationEffects: SharedFlow<CounterNavigationEffect> = _navigationEffects.asSharedFlow()

    fun increment() {
        viewModelScope.launch { counterRepository.increment() }
    }

    fun decrement() {
        viewModelScope.launch { counterRepository.decrement() }
    }

    fun onGoSecond(currentCount: Int) {
        viewModelScope.launch {
            _navigationEffects.emit(CounterNavigationEffect.ToSecond(currentCount))
        }
    }

    fun onGoSomething() {
        viewModelScope.launch {
            _navigationEffects.emit(CounterNavigationEffect.ToSomething)
        }
    }

    fun onGoProfile(userId: String) {
        viewModelScope.launch {
            _navigationEffects.emit(CounterNavigationEffect.ToProfile(userId))
        }
    }

    fun onGoHomeDemo() {
        viewModelScope.launch {
            _navigationEffects.emit(CounterNavigationEffect.ToHomeDemo)
        }
    }

    fun onGoHeartBeatDemo() {
        viewModelScope.launch {
            _navigationEffects.emit(CounterNavigationEffect.ToHeartBeatDemo)
        }
    }
}
