package com.mehdisekoba.digiato.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mehdisekoba.digiato.data.database.entity.NewsHotEntity
import com.mehdisekoba.digiato.data.database.entity.NewsSuggestionsEntity
import com.mehdisekoba.digiato.data.database.entity.NewsTodayEntity
import com.mehdisekoba.digiato.data.model.home.ResponseSuggestions
import com.mehdisekoba.digiato.data.model.home.ResponseToday
import com.mehdisekoba.digiato.data.model.home.ResponseTodayHot
import com.mehdisekoba.digiato.data.repository.HomeRepository
import com.mehdisekoba.digiato.utils.network.NetworkRequest
import com.mehdisekoba.digiato.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {


    //remote
    //today hot
    private val _todayHotData = MutableLiveData<NetworkRequest<ResponseTodayHot>>()
    val todayHotData: LiveData<NetworkRequest<ResponseTodayHot>> = _todayHotData

    fun callTodayHotApi() = viewModelScope.launch {
        _todayHotData.value = NetworkRequest.Loading()
        val response = repository.remote.getToadyHotList()
        _todayHotData.value = NetworkResponse(response).generateResponse()
        //cache
        val cache = _todayHotData.value?.data
        if (cache != null)
            offlineCacheTodayHot(cache)
    }

    private val _suggestData = MutableLiveData<NetworkRequest<ResponseSuggestions>>()
    val suggestData: LiveData<NetworkRequest<ResponseSuggestions>> = _suggestData
    fun callSuggestApi() = viewModelScope.launch {
        _suggestData.value = NetworkRequest.Loading()
        val response = repository.remote.getSuggestionsNewsList()
        _suggestData.value = NetworkResponse(response).generateResponse()
        //cache
        val cache = _suggestData.value?.data
        if (cache != null)
            offlineCacheSuggestions(cache)
    }

    //today news
    private val _todayNewsData = MutableLiveData<NetworkRequest<ResponseToday>>()
    val todayNewsData: LiveData<NetworkRequest<ResponseToday>> = _todayNewsData
    fun callTodayNewsApi() = viewModelScope.launch {
        _todayNewsData.value = NetworkRequest.Loading()
        val response = repository.remote.getTodayNewsList()
        _todayNewsData.value = NetworkResponse(response).generateResponse()
        //cache
        val cache = _todayNewsData.value?.data
        if (cache != null)
            offlineCacheToday(cache)

    }

    //local
    //today news
    private fun saveTodayHot(entity: NewsHotEntity) = viewModelScope.launch(IO) {
        repository.local.insertHotNews(entity)
    }

    val readTodayHotDb = repository.local.loadHotNews().asLiveData()
    private fun offlineCacheTodayHot(data: ResponseTodayHot) {
        val entity = NewsHotEntity(0, result = data)
        saveTodayHot(entity)
    }

    //suggestions
    private fun saveSuggestions(entity: NewsSuggestionsEntity) = viewModelScope.launch(IO) {
        repository.local.insertSuggestionsNews(entity)
    }

    val readSuggestionsDb = repository.local.loadSuggestionsNews().asLiveData()
    private fun offlineCacheSuggestions(data: ResponseSuggestions) {
        val entity = NewsSuggestionsEntity(1, result = data)
        saveSuggestions(entity)
    }

    //today
    private fun saveToday(entity: NewsTodayEntity) = viewModelScope.launch(IO) {
        repository.local.insertTodayNews(entity)
    }

    val readTodayDb = repository.local.loadTodayNews().asLiveData()
    private fun offlineCacheToday(data: ResponseToday) {
        val entity = NewsTodayEntity(2, result = data)
        saveToday(entity)
    }

}