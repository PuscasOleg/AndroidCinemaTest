package com.example.cinema.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinema.data.retrofit.RetrofitRepository
import com.example.cinema.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class HomePageViewModel : ViewModel() {

    private val repository = RetrofitRepository()

    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()


    //корутины узнать !!!??
    fun getMovies() {
        viewModelScope.launch {
            myMovies.value = repository.getMovies()
        }
    }

}