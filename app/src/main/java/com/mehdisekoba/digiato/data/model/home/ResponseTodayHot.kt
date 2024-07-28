package com.mehdisekoba.digiato.data.model.home


import com.google.gson.annotations.SerializedName

class ResponseTodayHot : ArrayList<ResponseTodayHot.ResponseTodayHotItem>(){
    data class ResponseTodayHotItem(
        @SerializedName("date")
        val date: String?, // 20 ساعت قبل
        @SerializedName("image")
        val image: String?, // https://static.digiato.com/digiato/2024/07/James_Gathany_courtesy_of_Centers_for_Disease.width-2500-80x80.jpg
        @SerializedName("title")
        val title: String? // همه‌چیز درباره پشه آئدس؛ تشخیص، علائم و درمان تب دنگی
    )
}