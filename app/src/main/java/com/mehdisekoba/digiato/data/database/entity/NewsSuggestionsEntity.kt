package com.mehdisekoba.digiato.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mehdisekoba.digiato.data.model.home.ResponseSuggestions
import com.mehdisekoba.digiato.utils.SUGGESTIONS_TABLE_NAME

@Entity(tableName = SUGGESTIONS_TABLE_NAME)
data class NewsSuggestionsEntity (
    @PrimaryKey(autoGenerate = false)
    var id: Int = 1,
    var result: ResponseSuggestions,
)