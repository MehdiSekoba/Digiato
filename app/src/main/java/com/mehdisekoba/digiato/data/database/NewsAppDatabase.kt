package com.mehdisekoba.digiato.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mehdisekoba.digiato.data.database.entity.MobileNewsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsHotEntity
import com.mehdisekoba.digiato.data.database.entity.NewsSuggestionsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsTodayEntity

@Database(entities = [NewsHotEntity::class, NewsSuggestionsEntity::class, NewsTodayEntity::class, MobileNewsEntity::class], version = 3, exportSchema = false)
@TypeConverters(NewsAppTypeConverter::class)
abstract class NewsAppDatabase :RoomDatabase(){
    abstract fun newsAppDao(): NewsAppDao
}