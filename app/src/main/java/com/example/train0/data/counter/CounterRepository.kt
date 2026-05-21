package com.example.train0.data.counter

import kotlinx.coroutines.flow.StateFlow

/**
 * Application-wide counter session. In a larger app this would be backed by persistence or domain use-cases.
 */
interface CounterRepository {
    fun observeCount(): StateFlow<Int>
    suspend fun increment()
    suspend fun decrement()
}
