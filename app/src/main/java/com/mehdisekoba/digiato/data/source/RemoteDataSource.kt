package com.mehdisekoba.digiato.data.source

import com.mehdisekoba.digiato.data.network.ApiServices
import javax.inject.Inject

class RemoteDataSource
@Inject
constructor(private val api: ApiServices) {
    suspend fun getSuggestionsNewsList() = api.getSuggestionsNewsList()

    suspend fun getTodayNewsList() = api.getTodayNewsList()
    suspend fun getToadyHotList() = api.getToadyHotList()
    suspend fun getMobileList() = api.getMobileList()


}
