package com.gmail.denuelle42.denuboilerplate.data.remote.services.sample

import com.gmail.denuelle42.denuboilerplate.data.repositories.sample.request.GetRequest
import com.gmail.denuelle42.denuboilerplate.data.repositories.sample.response.GetResponse
import com.gmail.denuelle42.denuboilerplate.utils.network.ALL_IMAGE_MIME_TYPE
import com.gmail.denuelle42.denuboilerplate.utils.network.asNetWorkRequestBody
import okhttp3.MultipartBody
import retrofit2.HttpException
import java.net.HttpURLConnection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitSampleServiceImpl @Inject constructor(
    private val api : SampleAPI
) : SampleService {
    override suspend fun login(request: GetRequest): GetResponse {
        TODO("Not yet implemented")
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }

    override suspend fun register() {
        TODO("Not yet implemented")
    }

    override suspend fun hasUser() {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentUser() {
        TODO("Not yet implemented")
    }

    override suspend fun sendEmailVerification(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun sendPasswordReset(email: String) {
        TODO("Not yet implemented")
    }

    suspend fun getRequest(request : GetRequest) : GetResponse {
        val map = mapOf(
            "id" to request.id
        ).filterValues { it != null }.mapValues { it.value.toString() }

        val response = api.getRequest()

        if(response.code() != HttpURLConnection.HTTP_OK){
            throw HttpException(response)
        }

        return response.body() ?: throw NullPointerException("Response data is empty")
    }

    suspend fun getMultiPartRequest(request : GetRequest) : GetResponse {
        val response = api.getMultiPartRequest(
            MultipartBody.Part.createFormData(
                "frontImagePart",
                request.frontImageFile?.name,
                request.frontImageFile.asNetWorkRequestBody(ALL_IMAGE_MIME_TYPE)
            ),
            MultipartBody.Part.createFormData(
                "backImagePart",
                request.backImageFile?.name,
                request.backImageFile.asNetWorkRequestBody(ALL_IMAGE_MIME_TYPE)
            ),
            MultipartBody.Part.createFormData("user_id", request.userId.orEmpty()),
        )

        if(response.code() != HttpURLConnection.HTTP_OK){
            throw HttpException(response)
        }

        return response.body() ?: throw NullPointerException("Response data is empty")
    }
}