package com.mehdisekoba.digiato.data.model.home


import com.google.gson.annotations.SerializedName

class ResponseSuggestions : ArrayList<ResponseSuggestions.ResponseSuggestionsItem>(){
    data class ResponseSuggestionsItem(
        @SerializedName("author")
        val author: String?, // آزاد کبیری
        @SerializedName("category")
        val category: String?, // میان رشته ای
        @SerializedName("date")
        val date: String?, // 24 دقیقه قبل
        @SerializedName("image")
        val image: String?, // https://static.digiato.com/digiato/2024/07/Sam-Altmans-giant-basic-income-study-is-out-Heres-what-388x462.jpeg
        @SerializedName("title")
        val title: String? // پژوهش سم آلتمن نشان داد: چه می‌شد اگر ماهانه 1000 دلار رایگان به مردم پول داده می‌شد؟
    )
}