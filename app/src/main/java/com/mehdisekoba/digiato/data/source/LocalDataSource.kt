package com.mehdisekoba.digiato.data.source

import com.mehdisekoba.digiato.data.database.NewsAppDao
import com.mehdisekoba.digiato.data.database.entity.MobileNewsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsHotEntity
import com.mehdisekoba.digiato.data.database.entity.NewsSuggestionsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsTodayEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: NewsAppDao) {
    //Home
    suspend fun insertHotNews(newsHotEntity: NewsHotEntity) = dao.insertHotNews(newsHotEntity)
    fun loadHotNews() = dao.loadHotNews()

    //Suggestions
    suspend fun insertSuggestionsNews(suggestionsEntity: NewsSuggestionsEntity) =
        dao.insertSuggestionsNews(suggestionsEntity)

    fun loadSuggestionsNews() = dao.loadSuggestionsNews()

    //Today
    suspend fun insertTodayNews(todayEntity: NewsTodayEntity) = dao.insertTodayNews(todayEntity)
    fun loadTodayNews() = dao.loadTodayNews()

    //mobile
    suspend fun insertMobileNews(mobileEntity: MobileNewsEntity) =
        dao.insertMobileNews(mobileEntity)

    fun loadMobileNews() = dao.loadMobileNews()


}