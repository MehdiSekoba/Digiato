package com.mehdisekoba.digiato.utils.di

import android.content.Context
import androidx.room.Room
import com.mehdisekoba.digiato.data.database.NewsAppDatabase
import com.mehdisekoba.digiato.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =Room.databaseBuilder(
        context,
        NewsAppDatabase::class.java,
        DATABASE_NAME
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(database: NewsAppDatabase) = database.newsAppDao()

}