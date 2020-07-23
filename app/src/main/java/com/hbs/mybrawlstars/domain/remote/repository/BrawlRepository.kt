package com.hbs.mybrawlstars.domain.remote.repository

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import javax.inject.Inject

interface BrawlRepository{
    fun getCharacters()
}

class BrawlRepositoryImpl @Inject constructor(private val brawlApi: BrawlApi) : BrawlRepository{
    override fun getCharacters() = brawlApi.getCharacters()
}