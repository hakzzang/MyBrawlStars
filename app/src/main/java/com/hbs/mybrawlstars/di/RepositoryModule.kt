package com.hbs.mybrawlstars.di

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepository
import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBrawlRepository(brawlApi: BrawlApi):BrawlRepository = BrawlRepositoryImpl(brawlApi)
}