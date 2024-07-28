package com.mehdisekoba.digiato.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mehdisekoba.digiato.data.database.entity.MobileNewsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsHotEntity
import com.mehdisekoba.digiato.data.database.entity.NewsSuggestionsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsTodayEntity
import com.mehdisekoba.digiato.utils.MOBILE_TABLE_NAME
import com.mehdisekoba.digiato.utils.SUGGESTIONS_TABLE_NAME
import com.mehdisekoba.digiato.utils.TODAY_HOT_TABLE_NAME
import com.mehdisekoba.digiato.utils.TODAY_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsAppDao {
    //hot news
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotNews(newsHotEntity: NewsHotEntity)

    @Query("SELECT * FROM $TODAY_HOT_TABLE_NAME")
    fun loadHotNews(): Flow<List<NewsHotEntity>>

    //suggestions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSuggestionsNews(newsSuggestions: NewsSuggestionsEntity)

    @Query("SELECT * FROM $SUGGESTIONS_TABLE_NAME")
    fun loadSuggestionsNews(): Flow<List<NewsSuggestionsEntity>>

    //today
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodayNews(newsTodayEntity: NewsTodayEntity)

    @Query("SELECT * FROM $TODAY_TABLE_NAME")
    fun loadTodayNews(): Flow<List<NewsTodayEntity>>

    //mobile
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMobileNews(newsEntity: MobileNewsEntity)

    @Query("SELECT * FROM $MOBILE_TABLE_NAME")
    fun loadMobileNews(): Flow<List<MobileNewsEntity>>


}