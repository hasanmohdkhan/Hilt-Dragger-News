package com.example.news.di

import com.example.news.network.NewsApi
import com.example.news.utils.Constant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }
    @Singleton
    @Provides
    fun provideLogging(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Singleton
    @Provides
    fun provideHttpClient():  OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }



    @Singleton
    @Provides
    fun provideRetrofitBuilder(gson: Gson,
                               logging: HttpLoggingInterceptor,
                               httpClient: OkHttpClient.Builder
    ): Retrofit.Builder {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())

    }

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit.Builder): NewsApi {
        return retrofit.build().create(NewsApi::class.java)
    }


}