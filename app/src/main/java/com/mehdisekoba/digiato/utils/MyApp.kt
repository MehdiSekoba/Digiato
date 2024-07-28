package com.mehdisekoba.digiato.utils

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //date
        AndroidThreeTen.init(this)
        //Calligraphy
        ViewPump.init(
                ViewPump.builder().addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/is_bold.ttf")
                            .build()
                    )
                ).build()
        )
    }
}