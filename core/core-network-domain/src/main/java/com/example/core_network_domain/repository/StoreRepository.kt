package com.example.core_network_domain.repository

import com.example.core_model.api.store.Store
import com.example.core_model.api.store.StoreInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface StoreRepository {

    suspend fun getStore(
        page:Int
    ):Response<Store>

    fun getStoreById(
        id:Int
    ):Single<StoreInfo>
}