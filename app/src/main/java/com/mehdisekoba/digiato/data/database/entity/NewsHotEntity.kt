package com.mehdisekoba.digiato.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mehdisekoba.digiato.data.model.home.ResponseTodayHot
import com.mehdisekoba.digiato.utils.TODAY_HOT_TABLE_NAME

@Entity(tableName = TODAY_HOT_TABLE_NAME)
data class NewsHotEntity (
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,
    var result: ResponseTodayHot,
)