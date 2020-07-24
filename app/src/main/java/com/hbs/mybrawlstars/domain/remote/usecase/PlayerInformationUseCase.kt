package com.hbs.mybrawlstars.domain.remote.usecase

import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepository
import com.hbs.mybrawlstars.model.BrawlStarsPlayer
import javax.inject.Inject

interface PlayerInformationUseCase{
    suspend fun getBrawlStarsPlayer(playerTag : String) : BrawlStarsPlayer
}

class PlayerInformationUseCaseImpl @Inject constructor(private val brawlRepository: BrawlRepository) : PlayerInformationUseCase{
    override suspend fun getBrawlStarsPlayer(playerTag: String): BrawlStarsPlayer = brawlRepository.getBrawlStarsPlayer(playerTag)
}