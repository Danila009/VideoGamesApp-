package com.example.core_network_domain.useCase.platform

import com.example.core_model.api.platform.PlatformInfo
import com.example.core_network_domain.repository.PlatformRepository
import com.example.core_network_domain.response.BaseApiResponse
import com.example.core_network_domain.response.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPlatformByIdUseCase @Inject constructor(
    private val platformRepository: PlatformRepository
):BaseApiResponse() {

    operator fun invoke(id:Int):Flow<Result<PlatformInfo>> = flow {
        emit( safeApiCall { platformRepository.getPlatformById(id) } )
    }
}