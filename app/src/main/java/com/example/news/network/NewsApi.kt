package com.example.news.network

import com.example.news.network.model.SearchResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi
{

    @GET("search?")
   suspend fun getResponseAsync(
        @Query("api-key") apiKey: String,
        @Query("show-fields") showFields: String,
        @Query("page") page: Int
    ): Response<SearchResponse>


}