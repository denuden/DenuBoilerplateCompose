package com.gmail.denuelle42.denuboilerplate.di.modules

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

//    @Provides
//    @Singleton
//    fun provideFirebaseAuth() : FirebaseAuth {
//        return Firebase.auth
//    }
}