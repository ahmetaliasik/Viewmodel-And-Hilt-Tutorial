package com.example.train0.data.counter

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Singleton
class DefaultCounterRepository @Inject constructor() : CounterRepository {
    private val mutex = Mutex()
    private val _count = MutableStateFlow(0)

    override fun observeCount(): StateFlow<Int> = _count.asStateFlow()

    override suspend fun increment() {
        mutex.withLock {
            _count.value = _count.value + 1
        }
    }

    override suspend fun decrement() {
        mutex.withLock {
            _count.value = _count.value - 1
        }
    }
}
