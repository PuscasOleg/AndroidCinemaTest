package com.example.cinema.data.retrofit

import com.example.cinema.data.retrofit.API.RetrofitInstance
import com.example.cinema.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {

    suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.API.getPopularMovie()
    }
}