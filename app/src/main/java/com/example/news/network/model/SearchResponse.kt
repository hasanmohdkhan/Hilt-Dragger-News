package com.example.news.network.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @field:SerializedName("response")
    val response: Response? = null
)

data class Response(

    @field:SerializedName("userTier")
    val userTier: String? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("startIndex")
    val startIndex: Int? = null,

    @field:SerializedName("pages")
    val pages: Int? = null,

    @field:SerializedName("pageSize")
    val pageSize: Int? = null,

    @field:SerializedName("orderBy")
    val orderBy: String? = null,

    @field:SerializedName("currentPage")
    val currentPage: Int? = null,

    @field:SerializedName("results")
    val results: List<ResultsItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null,

	@field:SerializedName("message")
    val message: String? = null


)

data class ResultsItem(

    @field:SerializedName("sectionName")
    val sectionName: String? = null,

    @field:SerializedName("pillarName")
    val pillarName: String? = null,

    @field:SerializedName("webPublicationDate")
    val webPublicationDate: String? = null,

    @field:SerializedName("apiUrl")
    val apiUrl: String? = null,

    @field:SerializedName("webUrl")
    val webUrl: String? = null,

    @field:SerializedName("isHosted")
    val isHosted: Boolean? = null,

    @field:SerializedName("pillarId")
    val pillarId: String? = null,

    @field:SerializedName("webTitle")
    val webTitle: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("sectionId")
    val sectionId: String? = null,

    @field:SerializedName("type")
    val type: String? = null
)
