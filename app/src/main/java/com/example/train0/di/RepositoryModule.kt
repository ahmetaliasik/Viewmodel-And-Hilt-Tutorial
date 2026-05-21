package com.example.train0.di

import com.example.train0.data.counter.CounterRepository
import com.example.train0.data.counter.DefaultCounterRepository
import com.example.train0.data.profile.DefaultProfileRepository
import com.example.train0.data.profile.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCounterRepository(impl: DefaultCounterRepository): CounterRepository

    @Binds
    @Singleton
    abstract fun bindProfileRepository(impl: DefaultProfileRepository): ProfileRepository
}
