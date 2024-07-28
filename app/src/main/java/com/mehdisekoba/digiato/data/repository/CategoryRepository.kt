package com.mehdisekoba.digiato.data.repository

import com.mehdisekoba.digiato.data.network.ApiServices
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getCategoryList() = api.getCategoryList()
}