package com.hbs.mybrawlstars.di

import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepository
import com.hbs.mybrawlstars.domain.remote.usecase.PlayerInformationUseCase
import com.hbs.mybrawlstars.domain.remote.usecase.PlayerInformationUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideCharacterUseCase(brawlRepository: BrawlRepository) : PlayerInformationUseCase = PlayerInformationUseCaseImpl(brawlRepository)
}