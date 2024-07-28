package com.mehdisekoba.digiato.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mehdisekoba.digiato.data.model.home.ResponseToday
import com.mehdisekoba.digiato.utils.TODAY_TABLE_NAME

@Entity(tableName = TODAY_TABLE_NAME)
data class NewsTodayEntity (
    @PrimaryKey(autoGenerate = false)
    var id: Int = 2,
    var result: ResponseToday,
)