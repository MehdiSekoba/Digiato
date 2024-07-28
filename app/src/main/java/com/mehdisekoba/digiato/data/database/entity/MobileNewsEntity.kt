package com.mehdisekoba.digiato.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo
import com.mehdisekoba.digiato.utils.MOBILE_TABLE_NAME

@Entity(tableName = MOBILE_TABLE_NAME)
data class MobileNewsEntity (
    @PrimaryKey(autoGenerate = false)
    var id: Int = 3,
    var result: ResponseMobileVideo,
)