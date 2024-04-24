package com.example.foodreminder.domain.dispatchers

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal class DispatchersModule {

    @Provides
    @DispatchersIO
    fun provideDispatchersIO(): CoroutineDispatcher = Dispatchers.IO
}