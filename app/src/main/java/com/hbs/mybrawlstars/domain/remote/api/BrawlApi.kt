package com.hbs.mybrawlstars.domain.remote.api

import retrofit2.http.GET
import retrofit2.http.Path

interface BrawlApi{
    @GET(BrawlApiResources.PLAYER_URL+"{playerTag}")
    fun getPlayerInformation(
        @Path("playerTag") playerTag: String
    )
}