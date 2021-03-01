package com.practice.moviz.di

import com.practice.moviz.data.model.Token
import com.practice.moviz.network.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import com.practice.moviz.util.API_HOST
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {


    @Provides
    fun apiKey(): Token {
        return Token("13fc16d0")
    }

    @Provides
    fun provideRetrofit(
    ) = Retrofit.Builder()
        .baseUrl(API_HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCarService(retrofit: Retrofit): MoviesService = retrofit.create(
        MoviesService::class.java
    )
}
