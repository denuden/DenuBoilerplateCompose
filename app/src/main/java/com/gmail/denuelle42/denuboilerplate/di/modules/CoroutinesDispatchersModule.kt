package com.gmail.denuelle42.denuboilerplate.di.modules

import com.gmail.denuelle42.denuboilerplate.di.qualifiers.DefaultDispatcher
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.IoDispatcher
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.MainDispatcher
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.MainImmediateDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesDispatchersModule {

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @MainImmediateDispatcher
    @Provides
    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
}