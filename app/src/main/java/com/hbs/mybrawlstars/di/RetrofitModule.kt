package com.hbs.mybrawlstars.di

import com.hbs.mybrawlstars.BuildConfig
import com.hbs.mybrawlstars.domain.remote.api.BrawlApi
import com.hbs.mybrawlstars.domain.remote.api.BrawlApiResources
import com.hbs.mybrawlstars.utils.retrofit.ErrorHandlingCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule{
    @Singleton
    @Provides
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideErrorHandlingCallAdapterFactory() = ErrorHandlingCallAdapterFactory()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .connectionPool(ConnectionPool(5,20, TimeUnit.SECONDS))
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            }else{
                HttpLoggingInterceptor.Level.BASIC
            }
        }).build()


    @Singleton
    @Provides
    fun provideRetrofit(
        errorHandlingCallAdapterFactory:ErrorHandlingCallAdapterFactory,
        gsonConverterFactory: GsonConverterFactory,
        client:OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BrawlApiResources.BASE_URL)
        .addCallAdapterFactory(errorHandlingCallAdapterFactory)
        .addConverterFactory(gsonConverterFactory)
        .client(client)
        .build()

    @Singleton
    @Provides
    fun provideBrawlApi(retrofit: Retrofit): BrawlApi =
        retrofit.create(BrawlApi::class.java)
}