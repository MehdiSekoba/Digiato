package com.mehdisekoba.digiato.data.repository

import com.mehdisekoba.digiato.data.source.LocalDataSource
import com.mehdisekoba.digiato.data.source.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class HomeRepository
@Inject
constructor(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) {
    val remote = remoteDataSource
    val local = localDataSource

}
