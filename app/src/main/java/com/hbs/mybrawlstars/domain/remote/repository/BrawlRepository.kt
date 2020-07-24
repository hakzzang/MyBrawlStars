package com.hbs.mybrawlstars.domain.remote.repository

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import javax.inject.Inject

interface BrawlRepository{
    fun getPlayerInformation(playerTag:String)
}

class BrawlRepositoryImpl @Inject constructor(private val brawlApi: BrawlApi) : BrawlRepository{
    override fun getPlayerInformation(playerTag: String) = brawlApi.getPlayerInformation(playerTag)
}