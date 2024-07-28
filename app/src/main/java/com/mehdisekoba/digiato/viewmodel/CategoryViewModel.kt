package com.mehdisekoba.digiato.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehdisekoba.digiato.data.model.category.ResponseCategory
import com.mehdisekoba.digiato.data.repository.CategoryRepository
import com.mehdisekoba.digiato.utils.network.NetworkRequest
import com.mehdisekoba.digiato.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {
    init {
        viewModelScope.launch {
            delay(200)
            callCategoryApi()
        }
    }

    //category
    private val _categoryData = MutableLiveData<NetworkRequest<ResponseCategory>>()
    val categoryData: LiveData<NetworkRequest<ResponseCategory>> = _categoryData
    private fun callCategoryApi() = viewModelScope.launch {
        _categoryData.value = NetworkRequest.Loading()
        val response = repository.getCategoryList()
        _categoryData.value = NetworkResponse(response).generateResponse()
    }
}