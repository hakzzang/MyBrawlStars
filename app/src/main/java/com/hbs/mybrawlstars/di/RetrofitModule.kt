package com.hbs.mybrawlstars.di

import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import com.hbs.mybrawlstars.domain.remote.api.BrawlApiResources
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@EntryPoint
@InstallIn(ApplicationComponent::class)
class RetrofitModule{
    @Singleton
    @Provides
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .connectionPool(ConnectionPool(5,20, TimeUnit.SECONDS))
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }).build()


    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        client:OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BrawlApiResources.BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(client)
        .build()

    @Singleton
    @Provides
    fun provideCurrencyApi(retrofit: Retrofit): BrawlApi =
        retrofit.create(BrawlApi::class.java)

}