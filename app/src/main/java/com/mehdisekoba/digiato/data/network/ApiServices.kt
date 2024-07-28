package com.mehdisekoba.digiato.data.network

import com.mehdisekoba.digiato.data.model.category.ResponseCategory
import com.mehdisekoba.digiato.data.model.home.ResponseSuggestions
import com.mehdisekoba.digiato.data.model.home.ResponseToday
import com.mehdisekoba.digiato.data.model.home.ResponseTodayHot
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("suggestions.php")
    suspend fun getSuggestionsNewsList(): Response<ResponseSuggestions>

    @GET("todayNews.php")
    suspend fun getTodayNewsList(): Response<ResponseToday>

    @GET("category.php")
    suspend fun getCategoryList(): Response<ResponseCategory>

    @GET("mobile.php")
    suspend fun getMobileList(): Response<ResponseMobileVideo>

    @GET("TodayHot.php")
    suspend fun getToadyHotList(): Response<ResponseTodayHot>

}
