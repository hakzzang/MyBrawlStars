package com.hbs.mybrawlstars.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.hbs.mybrawlstars.domain.remote.api.ApiResult
import com.hbs.mybrawlstars.domain.remote.usecase.PlayerInformationUseCase
import kotlinx.coroutines.Dispatchers


class MainViewModel @ViewModelInject constructor(private val playerInformationUseCase: PlayerInformationUseCase) : ViewModel() {
    val playerInformation = liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
        emit(ApiResult.Loading)
        try{
            val apiResult = playerInformationUseCase.getBrawlStarsPlayer("#VV00QG2C")
            emit(apiResult)
        }catch (exception:Exception){
            emit(ApiResult.Fail(exception))
        }
    }
}