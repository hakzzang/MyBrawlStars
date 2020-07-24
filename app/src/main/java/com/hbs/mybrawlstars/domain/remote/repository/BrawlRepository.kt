package com.hbs.mybrawlstars.domain.remote.repository

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import com.hbs.mybrawlstars.model.BrawlStarsPlayer
import javax.inject.Inject

interface BrawlRepository{
    suspend fun getBrawlStarsPlayer(playerTag:String) : BrawlStarsPlayer
}

class BrawlRepositoryImpl @Inject constructor(private val brawlApi: BrawlApi) : BrawlRepository{
    override suspend fun getBrawlStarsPlayer(playerTag: String) = brawlApi.getBrawlStarsPlayer(playerTag)
}