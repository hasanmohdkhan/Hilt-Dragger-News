package com.example.news.di

import com.example.news.network.NewsApi
import com.example.news.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(newsApi: NewsApi):Repository{
        return Repository(newsApi)
    }

}