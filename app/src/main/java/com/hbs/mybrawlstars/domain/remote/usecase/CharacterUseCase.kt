package com.hbs.mybrawlstars.domain.remote.usecase

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepository
import javax.inject.Inject

interface CharacterUseCase{
    fun getCharacters()
}

class CharacterUseCaseImpl @Inject constructor(private val brawlRepository: BrawlRepository){
    fun getCharacters() = brawlRepository.getCharacters()
}