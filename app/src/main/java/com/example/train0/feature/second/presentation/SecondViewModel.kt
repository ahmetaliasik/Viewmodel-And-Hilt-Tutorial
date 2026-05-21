package com.example.train0.feature.second.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.train0.data.counter.CounterRepository
import com.example.train0.navigation.TrainRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class SecondViewModel @Inject constructor(
    counterRepository: CounterRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    /** Value passed through navigation when this destination was opened. */
    val routeCount: Int =
        checkNotNull(savedStateHandle.get<Int>(TrainRoutes.Args.COUNT)) {
            "Route `${TrainRoutes.SECOND_PATTERN}` requires `${TrainRoutes.Args.COUNT}`"
        }

    /** Live counter shared with other destinations via [CounterRepository]. */
    val liveCount: StateFlow<Int> = counterRepository
        .observeCount()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), 0)
}
