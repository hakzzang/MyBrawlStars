package com.hbs.mybrawlstars.di

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepositoryImpl
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@EntryPoint
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideBrawlRepository(brawlApi: BrawlApi) = BrawlRepositoryImpl(brawlApi)
}