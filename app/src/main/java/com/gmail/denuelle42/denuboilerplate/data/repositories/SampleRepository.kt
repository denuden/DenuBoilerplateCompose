package com.gmail.denuelle42.denuboilerplate.data.repositories

import androidx.datastore.core.DataStore
import com.gmail.denuelle42.denuboilerplate.data.remote.models.sample.request.GetRequest
import com.gmail.denuelle42.denuboilerplate.data.remote.models.sample.response.GetResponse
import com.gmail.denuelle42.denuboilerplate.data.remote.services.sample.SampleService
import com.gmail.denuelle42.denuboilerplate.data.storage.UserPreferences
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.FirebaseSample
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

//Repository = Regarding about the backend response
// provides abstraction to service
//one is to one to the service
//this will be the source of truth for local or remote
//cleans data that you need
@ViewModelScoped
class SampleRepository @Inject constructor(
    @FirebaseSample private val service : SampleService,
    private val dataStore: DataStore<UserPreferences>,
    ) {
    suspend fun login(request: GetRequest) : GetResponse {
        val user = service.login(request)
        dataStore.updateData {
            UserPreferences(
                token = user.name, //put token here
            )
        }
        return user
    }
}