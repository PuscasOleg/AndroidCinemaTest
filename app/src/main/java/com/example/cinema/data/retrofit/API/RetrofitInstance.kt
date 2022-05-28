package com.example.cinema.data.retrofit.API

import com.example.cinema.BASE_Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    //инициализируем Retrofit.
    // addConverterFactory конвертирует JSON  в необходимый формат
    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_Url).addConverterFactory(GsonConverterFactory.create())
            .build()


    val API: ApiService =
        retrofit.create(ApiService::class.java)

}