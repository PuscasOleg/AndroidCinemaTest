package com.example.cinema.data.retrofit.API

import com.example.cinema.BASE_Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    //разобрать !!
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_Url).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val API:ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}