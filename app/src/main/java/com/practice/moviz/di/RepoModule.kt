package com.practice.moviz.di

import com.practice.moviz.repositories.MoviesRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface MoviesRepositoryEntryPoint {
    fun amoviesRepository(): MoviesRepository
}
