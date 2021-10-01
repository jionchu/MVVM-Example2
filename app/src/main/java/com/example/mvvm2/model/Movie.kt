package com.example.mvvm2.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title") val title: String,
    @SerializedName("link") val link: String,
    @SerializedName("image") val image: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("pubDate") val pubDate: String,
    @SerializedName("userRating") val rating: String,
    @SerializedName("director") val director: String,
    @SerializedName("actor") val actor: String
)