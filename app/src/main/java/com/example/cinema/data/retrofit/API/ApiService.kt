package com.example.cinema.data.retrofit.API

import com.bumptech.glide.load.engine.Resource
import com.example.cinema.models.MoviesModel
import retrofit2.http.GET

interface ApiService {
    @GET("3/movie/popular?api_key=3c40304a8b270b4e74ab11a81811c4f7&language=en-US&page=1")
    suspend fun getPopularMovie():Resource<MoviesModel>

}