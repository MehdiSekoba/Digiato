package com.mehdisekoba.digiato.utils.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mehdisekoba.digiato.BuildConfig
import com.mehdisekoba.digiato.data.network.ApiServices
import com.mehdisekoba.digiato.utils.BASE_URL
import com.mehdisekoba.digiato.utils.CONNECTION_TIME
import com.mehdisekoba.digiato.utils.NAMED_PING
import com.mehdisekoba.digiato.utils.PING_INTERVAL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideClient(
        timeOut: Long,
        @Named(NAMED_PING) ping: Long,
        interceptor: HttpLoggingInterceptor,
    ) = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .writeTimeout(timeOut, TimeUnit.SECONDS)
        .readTimeout(timeOut, TimeUnit.SECONDS)
        .connectTimeout(timeOut, TimeUnit.SECONDS)
        .pingInterval(ping, TimeUnit.SECONDS)
        .build()


    @Provides
    @Singleton
    fun provideInterceptor() = HttpLoggingInterceptor().apply {
       level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    fun provideTimeout() = CONNECTION_TIME

    @Provides
    @Singleton
    @Named(NAMED_PING)
    fun providePingInterval() = PING_INTERVAL

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, gson: Gson, client: OkHttpClient): ApiServices =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiServices::class.java)
}


