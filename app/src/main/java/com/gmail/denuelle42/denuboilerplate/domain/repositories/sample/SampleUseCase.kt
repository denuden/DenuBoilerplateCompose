package com.gmail.denuelle42.denuboilerplate.domain.repositories.sample

import com.gmail.denuelle42.denuboilerplate.data.repositories.SampleRepository
import com.gmail.denuelle42.denuboilerplate.di.qualifiers.IoDispatcher
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Only for merging data and other logics that requires use case
 */
@ViewModelScoped
class SampleUseCase @Inject constructor(
    private val sampleRepository: SampleRepository,
//    private val anotherRepository: SampleRepository
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    fun mergeDataFromDifferentRepositories() {

    }
}