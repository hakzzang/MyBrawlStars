package com.hbs.mybrawlstars.domain.remote.api

import com.hbs.mybrawlstars.model.BrawlStarsPlayer
import retrofit2.http.GET
import retrofit2.http.Path

interface BrawlApi{
    @GET(BrawlApiResources.PLAYER_URL+"{playerTag}")
    suspend fun getBrawlStarsPlayer(
        @Path("playerTag") playerTag: String
    ):BrawlStarsPlayer
}