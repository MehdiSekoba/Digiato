package com.mehdisekoba.digiato.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mehdisekoba.digiato.data.database.entity.MobileNewsEntity
import com.mehdisekoba.digiato.data.model.video.ResponseMobileVideo
import com.mehdisekoba.digiato.data.repository.MobileRepository
import com.mehdisekoba.digiato.utils.network.NetworkRequest
import com.mehdisekoba.digiato.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MobileViewModel @Inject constructor(private val repository: MobileRepository) :
    ViewModel() {
    //category
    //remote
    private val _mobileData = MutableLiveData<NetworkRequest<ResponseMobileVideo>>()
    val mobileData: LiveData<NetworkRequest<ResponseMobileVideo>> = _mobileData
    fun callMobileApi() = viewModelScope.launch {
        _mobileData.value = NetworkRequest.Loading()
        val response = repository.remote.getMobileList()
        _mobileData.value = NetworkResponse(response).generateResponse()
        //cache
        val cache = _mobileData.value?.data
        if (cache != null)
            offlineCacheMobile(cache)

    }

    //local
    private fun saveMobile(entity: MobileNewsEntity) = viewModelScope.launch(IO) {
        repository.local.insertMobileNews(entity)
    }
    val readMobileDb = repository.local.loadMobileNews().asLiveData()
    private fun offlineCacheMobile(data: ResponseMobileVideo) {
        val entity = MobileNewsEntity(3, result = data)
        saveMobile(entity)
    }
}