package com.example.mvvm2.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("lastBuildDate") val lastBuildDate: String,
    @SerializedName("total") val total: Int,
    @SerializedName("start") val start: Int,
    @SerializedName("display") val display: Int,
    @SerializedName("items") val movies: List<Movie>
)