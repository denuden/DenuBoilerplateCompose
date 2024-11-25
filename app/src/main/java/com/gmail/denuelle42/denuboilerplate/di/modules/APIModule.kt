package com.gmail.denuelle42.denuboilerplate.di.modules

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

//    @Provides
//    @Singleton
//    fun provideSampleAPI(retrofit: Retrofit): PeopleAPI {
//        return retrofit.create(PeopleAPI::class.java)
//    }
}