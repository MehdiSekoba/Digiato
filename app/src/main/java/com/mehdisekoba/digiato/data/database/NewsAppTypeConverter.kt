package com.mehdisekoba.digiato.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mehdisekoba.digiato.data.model.home.ResponseSuggestions
import com.mehdisekoba.digiato.data.model.home.ResponseToday
import com.mehdisekoba.digiato.data.model.home.ResponseTodayHot
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo

class NewsAppTypeConverter {
    private val gson = Gson()

    //hot news
    @TypeConverter
    fun hotNewsToJson(result: ResponseTodayHot): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToHotNews(data: String): ResponseTodayHot {
        return gson.fromJson(data, ResponseTodayHot::class.java)
    }

    //suggestion
    @TypeConverter
    fun suggestionNewsToJson(result: ResponseSuggestions): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToSuggestionNews(data: String): ResponseSuggestions {
        return gson.fromJson(data, ResponseSuggestions::class.java)
    }

    //today news
    @TypeConverter
    fun todayNewsToJson(result: ResponseToday): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToTodayNews(data: String): ResponseToday {
        return gson.fromJson(data, ResponseToday::class.java)
    }
    
    //mobile
    @TypeConverter
    fun mobileNewsToJson(result: ResponseMobileVideo): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToMobileNews(data: String): ResponseMobileVideo {
        return gson.fromJson(data, ResponseMobileVideo::class.java)
    }


}