package com.gmail.denuelle42.denuboilerplate.data.repositories.sample

import com.gmail.denuelle42.denuboilerplate.data.remote.services.sample.SampleService
import com.gmail.denuelle42.denuboilerplate.data.repositories.sample.request.GetRequest
import com.gmail.denuelle42.denuboilerplate.data.repositories.sample.response.GetResponse
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.FirebaseSample
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SampleRepository @Inject constructor(
    @FirebaseSample private val service : SampleService
) {
    suspend fun login(request: GetRequest) : GetResponse{
        return service.login(request)
    }
}