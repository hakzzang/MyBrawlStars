package com.hbs.mybrawlstars.di

import com.hbs.mybrawlstars.domain.remote.repository.BrawlRepository
import com.hbs.mybrawlstars.domain.remote.usecase.PlayerInformationUseCaseImpl
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@EntryPoint
@InstallIn(ApplicationComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideCharacterUseCase(brawlRepository: BrawlRepository) = PlayerInformationUseCaseImpl(brawlRepository)
}