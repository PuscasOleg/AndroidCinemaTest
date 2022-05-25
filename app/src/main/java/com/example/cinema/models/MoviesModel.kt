package com.example.cinema.models

data class MoviesModel(
    val page: Int,
    val movieItemModels: List<MovieItemModel>,
    val total_pages: Int,
    val total_results: Int
)