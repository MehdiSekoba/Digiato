package com.mehdisekoba.digiato.data.model.category


import com.google.gson.annotations.SerializedName

class ResponseCategory : ArrayList<ResponseCategory.ResponseCategoryItem>(){
    data class ResponseCategoryItem(
        @SerializedName("category")
        val category: String?, // Technology
        @SerializedName("image")
        val image: String?, // https://news.mehdisekoba.ir/images/Technology.png
        @SerializedName("title")
        val title: String? // تکنولوژی
    )
}