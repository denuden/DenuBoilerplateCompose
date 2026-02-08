package com.gmail.denuelle42.denuboilerplate.data.remote.services.sample

import com.gmail.denuelle42.denuboilerplate.data.repositories.sample.request.GetRequest
import com.gmail.denuelle42.denuboilerplate.data.repositories.sample.response.GetResponse


/**
 * “I define a service contract that represents what the app needs, not how it’s implemented.
 * Firebase and Retrofit are just implementations of that contract.
 * The repository depends only on the contract, so it’s backend-agnostic.
 * Hilt decides which implementation to provide using qualifiers.
 * This lets me swap backends without touching business logic or UI.”
 */
//contract
interface SampleService {
    suspend fun login(request : GetRequest) : GetResponse
    suspend fun logout()
    suspend fun register()
    suspend fun hasUser()
    suspend fun getCurrentUser()
    suspend fun sendEmailVerification(email : String)
    suspend fun sendPasswordReset(email : String)
}