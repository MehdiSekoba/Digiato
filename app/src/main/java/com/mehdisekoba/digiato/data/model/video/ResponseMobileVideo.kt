package com.mehdisekoba.digiato.data.model.video


import com.google.gson.annotations.SerializedName

class ResponseMobileVideo : ArrayList<ResponseMobileVideo.ResponseMobileVideoItem>(){
    data class ResponseMobileVideoItem(
        @SerializedName("author")
        val author: String?, // مهرانا عیسی‌پور
        @SerializedName("author_avatar")
        val authorAvatar: String?, // https://digiato.com/wp-content/uploads/avatars/280902-1712054156-32x32.jpg
        @SerializedName("category")
        val category: String?, // نقد و بررسی‌
        @SerializedName("date")
        val date: String?, // 5 روز قبل
        @SerializedName("description")
        val description: String?, // به‌نظر می‌رسد سامسونگ گلکسی Z Fold 6 یک گوشی تاشو جذاب با قابلیت‌های جدید هوش مصنوعی در یک طراحی سبک‌تر و بادوام‌تر است
        @SerializedName("image")
        val image: String?, // https://static.digiato.com/digiato/2024/07/zfold-6-review-Digiato-01-791x482.jpg.webp
        @SerializedName("title")
        val title: String? // بررسی سامسونگ گلکسی زدفولد 6: دوست‌داشتنی و قدرتمند
    )
}