package com.hbs.mybrawlstars.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hbs.mybrawlstars.domain.remote.usecase.CharacterUseCase

class MainViewModel @ViewModelInject constructor(private val characterUseCase: CharacterUseCase) : ViewModel() {
    private val character = MutableLiveData {
        characterUseCase.getCharacters()
    }
}