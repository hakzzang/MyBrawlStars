package com.hbs.mybrawlstars.domain.remote.usecase

import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepository
import javax.inject.Inject

interface PlayerInformationUseCase{
    fun getPlayerInformation(playerTag : String)
}

class PlayerInformationUseCaseImpl @Inject constructor(private val brawlRepository: BrawlRepository) : PlayerInformationUseCase{
    override fun getPlayerInformation(playerTag: String) = brawlRepository.getPlayerInformation(playerTag)
}