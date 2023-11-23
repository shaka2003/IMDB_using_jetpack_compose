package com.dicoding.jetreward.model

data class Movie(
    val id: Long,
    val image: Int,
    val title: String,
    val release: Int,
    val sinopsis: String,
    val director: String,
    val cast: String
)