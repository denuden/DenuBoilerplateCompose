package com.gmail.denuelle42.denuboilerplate.di.modules

import com.gmail.denuelle42.denuboilerplate.data.remote.services.sample.FirebaseSampleServiceImpl
import com.gmail.denuelle42.denuboilerplate.data.remote.services.sample.RetrofitSampleServiceImpl
import com.gmail.denuelle42.denuboilerplate.data.remote.services.sample.SampleService
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.FirebaseSample
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.RetrofitSample
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    //it does not create the instance itself, it just tells Hilt:
    //“Use this implementation whenever you need the interface or the one that its returning”
    //It’s essentially a mapping between an interface (contract) and its implementation.

    //select either retrofit impl or firebase impl
    @Binds
    @FirebaseSample
    abstract fun bindSampleService(sampleServiceImpl: FirebaseSampleServiceImpl): SampleService

    @Binds
    @RetrofitSample
    abstract fun bindSampleService(sampleServiceImpl: RetrofitSampleServiceImpl): SampleService
}