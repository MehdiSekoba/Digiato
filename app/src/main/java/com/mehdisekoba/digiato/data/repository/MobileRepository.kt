package com.mehdisekoba.digiato.data.repository

import com.mehdisekoba.digiato.data.source.LocalDataSource
import com.mehdisekoba.digiato.data.source.RemoteDataSource
import javax.inject.Inject

class MobileRepository @Inject constructor(remoteDataSource: RemoteDataSource,localDataSource: LocalDataSource) {
    val remote = remoteDataSource
    val local = localDataSource

}