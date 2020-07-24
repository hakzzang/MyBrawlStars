package com.hbs.mybrawlstars.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hbs.mybrawlstars.domain.remote.usecase.PlayerInformationUseCase

class MainViewModel @ViewModelInject constructor(private val playerInformationUseCase: PlayerInformationUseCase) : ViewModel() {
    private val character = MutableLiveData {
        playerInformationUseCase.getPlayerInformation("HELLO")
    }
}