package com.mehdisekoba.digiato.data.model.home


import com.google.gson.annotations.SerializedName

class ResponseToday : ArrayList<ResponseToday.ResponseTodayItem>(){
    data class ResponseTodayItem(
        @SerializedName("author")
        val author: String?, // حمیدرضا علیا
        @SerializedName("author_avatar")
        val authorAvatar: String?, // https://digiato.com/wp-content/uploads/avatars/292874-1707111771-32x32.jpg
        @SerializedName("category")
        val category: String?, // کامپیوتر و سخت افزار
        @SerializedName("date")
        val date: String?, // 7 ساعت قبل
        @SerializedName("description")
        val description: String?, // گزارشی تازه می‌گوید انویدیا به احتمال زیاد نسل بعدی کارت‌های گرافیکی گیمینگ RTX 50 Blackwell را تا پایان سال جاری میلادی معرفی نمی‌کند.
        @SerializedName("image")
        val image: String?, // https://static.digiato.com/digiato/2024/07/hAcZNwUpeQQAsWfS7LZ4DC-1200-80-791x482.jpg.webp
        @SerializedName("title")
        val title: String? // انویدیا احتمالاً پردازشگرهای گرافیکی RTX 50 Blackwell را در CES 2025 معرفی می‌کند
    )
}