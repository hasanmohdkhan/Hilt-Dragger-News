package com.example.news.repository

import android.util.Log
import com.example.news.BuildConfig
import com.example.news.network.NewsApi
import com.example.news.network.model.ErrorResponse
import com.example.news.network.model.Response
import com.example.news.utils.Constant
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject


class Repository(
    private val newsApi: NewsApi
) {

    suspend fun get() {
        val responseAsync = newsApi.getResponseAsync(
            apiKey = BuildConfig.API_KEY,
            showFields = Constant.SHOW_FIELDS,
            page = Constant.DEFAULT_VALUE
        )

        if (responseAsync.isSuccessful) {
            Log.d("REPO", "get: " + (responseAsync.body()?.response?.results?.size))
        } else {
            val errorBody: ResponseBody? = responseAsync.errorBody()
            handleErrorResponse(errorBody)
        }


    }

    private fun handleErrorResponse(errorBody: ResponseBody?) {
        val error = errorBody?.string()
        val gson = Gson()
        val errorResponse: ErrorResponse = gson.fromJson(error, ErrorResponse::class.java)
        Log.d("REPO", "Error: $error")
        Log.d("REPO", "msg-> " + errorResponse.body?.message)
        Log.d("REPO", "status-> " + errorResponse.body?.status)
    }

}